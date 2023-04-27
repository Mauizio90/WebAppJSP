package eu.mauizio90.webAppMaurizio.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 *
 * @author mauiz
 */
@Entity
@Table(name = "TODOS")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    
    @Size(min = 10, max = 50, message = "Usa almeno 10 caratteri")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public Todo() {
    }
    

    public Todo(String username, String description, LocalDate targetDate, boolean done) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDo{" + "id=" + id + ", username=" + username + ", description=" + description + ", targetDate=" + targetDate + ", done=" + done + '}';
    }
    
    
}
