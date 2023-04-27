package eu.mauizio90.webAppMaurizio.services;
import eu.mauizio90.webAppMaurizio.todo.Todo;
import eu.mauizio90.webappmaurizio.repositories.TodoRepo;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauiz
 */
@Service
public class ToDoService {
    
    @Autowired
    private TodoRepo todoRepo;
    
    
    public List<Todo> findByUsername(String username){
        return todoRepo.findByUsername(username);
    }
    
    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(username, description, targetDate, done);
        todoRepo.save(todo);
    }
    
    public void deleteById(Long id){
        todoRepo.deleteById(id);
    }
    
    public void findById(Long id){
        todoRepo.findById(id);
    }

    

    public void updateTodo(@Valid Todo todo) {
        todoRepo.deleteById(todo.getId());
        todoRepo.save(todo);
    }
}
