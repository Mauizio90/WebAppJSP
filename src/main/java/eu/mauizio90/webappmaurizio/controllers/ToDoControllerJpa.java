package eu.mauizio90.webappmaurizio.controllers;

import eu.mauizio90.webAppMaurizio.services.ToDoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import eu.mauizio90.webAppMaurizio.todo.Todo;
import eu.mauizio90.webappmaurizio.repositories.TodoRepo;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author mauiz
 */
@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {
    
    @Autowired
    private ToDoService toDoService;
    
    @Autowired
    private TodoRepo todoRepo;
    
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedinUsername(model);
        
        List<Todo> listTodos = todoRepo.findByUsername(username);
        model.addAttribute("todos",listTodos);
        return "listTodos";
    }

    private String getLoggedinUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName(); 
    }
    
    @RequestMapping(value = "add-todos", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = getLoggedinUsername(model);
        Todo todo = new Todo(username, "Default Description", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "addTodos";
    }
    
    @RequestMapping(value = "add-todos", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model,@Valid Todo todo, BindingResult result){
        
        if(result.hasErrors()){
            return "addTodos";
        }
        
        String username = getLoggedinUsername(model);
        todo.setUsername(username);
        todoRepo.save(todo);
        return "redirect:list-todos";
    }
    
    @RequestMapping("delete-todos")
    public String deleteTodos(@RequestParam Long id){
        toDoService.deleteById(id);
        return "redirect:list-todos";
    }
    
    @RequestMapping(value = "update-todos", method = RequestMethod.GET)
    public String showUpdateTodos(@RequestParam Long id, ModelMap model){
        Optional<Todo> todo = todoRepo.findById(id);
        model.addAttribute("todo", todo);
        return "addTodos";
    }
    
    @RequestMapping(value = "update-todos", method = RequestMethod.POST)
    public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result, @RequestParam Long id){

        if(result.hasErrors()){
            return "addTodos";
        }

        todo.setId(id);
        String username = getLoggedinUsername(model);
        todo.setUsername(username);
        toDoService.updateTodo(todo);
        return "redirect:list-todos";
    }
    
    private String getLoggedInUsername(ModelMap model) {
            Authentication authentication = 
                            SecurityContextHolder.getContext().getAuthentication();
            return authentication.getName();
    }
}
