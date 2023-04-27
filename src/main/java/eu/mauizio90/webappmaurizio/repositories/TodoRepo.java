package eu.mauizio90.webappmaurizio.repositories;

import eu.mauizio90.webAppMaurizio.todo.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mauiz
 */
public interface TodoRepo extends JpaRepository<Todo, Long>{
    public List<Todo> findByUsername(String username);

    public List<Todo> findByUsernameIgnoreCase(String username);
    
}
