package service;

import jakarta.validation.Valid;
import model.Task;
import org.springframework.stereotype.Service;
import repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findByUsuario(String usuario) {
        return taskRepository.findByUsuario(usuario);
    }

    public void addTask(String usuario, String descricao, LocalDate dataAlvo, boolean feito) {
        Task task = new Task(null, usuario, descricao, dataAlvo, feito);
        taskRepository.save(task);
    }

    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }

    public Task findById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void atualizarTask(@Valid Task task) {
        taskRepository.save(task);
    }
}
