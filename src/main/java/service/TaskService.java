package service;

import jakarta.validation.Valid;
import model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TaskService {
    private static List<Task> tasks = new ArrayList<>();

    private static int tasksCount = 0;
    static {
        tasks.add(new Task(++tasksCount, "Zecardinho", "Aprenda Java", LocalDate.now().plusYears(1), false));
        tasks.add(new Task(++tasksCount, "Zecardinho", "Aprenda Spring Framework", LocalDate.now().plusYears(2), false));
        tasks.add(new Task(++tasksCount, "Zecardinho", "Aprenda Arquitetura de Software", LocalDate.now().plusYears(3), false));
    }

    public List<Task> findByUsuario(String usuario) {
        Predicate<? super Task> predicate = task -> task.getUsuario().equalsIgnoreCase(usuario);
        return tasks.stream().filter(predicate).toList();
    }

    public void addTask(String usuario, String descricao, LocalDate dataAlvo, boolean feito) {
        Task task = new Task(++tasksCount,usuario, descricao, dataAlvo, feito);
        tasks.add(task);
    }

    public void deleteById(Integer id) {
        Predicate<? super Task> predicate = task -> task.getId() == id;
        tasks.removeIf(predicate);
    }

    public Task findById(Integer id) {
        Predicate<? super Task> predicate = task -> task.getId() == id;
        Task task = tasks.stream().filter(predicate).findFirst().get();
        return task;
    }

    public void atualizarTask(@Valid Task task) {
        deleteById(task.getId());
        tasks.add(task);
    }
}
