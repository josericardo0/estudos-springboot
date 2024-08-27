package controller;

import jakarta.validation.Valid;
import model.Task;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.TaskRepository;
import service.TaskService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TaskControllerJPA {

    public TaskControllerJPA(TaskService taskService, TaskRepository taskRepository) {
        super();
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    private final TaskService taskService;

    private final TaskRepository taskRepository;


    @RequestMapping("listar-tasks")
    public String listarTarefas(ModelMap modelo) {
        String usuario = (String)modelo.get("nome");
        List<Task> tasks = taskRepository.findByUsuario(usuario);
        modelo.addAttribute("tasks", tasks);
        return "listarTasks";
    }

    @RequestMapping(value = "add-tarefa", method = RequestMethod.GET)
    public String paginaMostrarNovaTarefa(ModelMap modelo) {
        String usuario = (String)modelo.get("nome");
        Task task = new Task(0, usuario, "Descricao padrao", LocalDate.now().plusYears(1), false);
        modelo.put("task", task);
        return "task";
    }

    @RequestMapping(value = "add-tarefa", method = RequestMethod.POST)
    public String adicionarTarefa(ModelMap modelo, @Valid Task task, BindingResult resultado) {
        if(resultado.hasErrors()) {
            return "task";
        }
        String usuario = (String)modelo.get("nome");
        taskService.addTask(usuario, task.getDescricao(), task.getDataAlvo(), false);
        return "redirect:listar-tasks";
    }

    @RequestMapping("deletar-task")
    public String deletarTarefa(@RequestParam Integer id, ModelMap modelo) {
        taskService.deleteById(id);
        List<Task> tasks = taskService.findByUsuario((String)modelo.get("nome"));
        modelo.addAttribute("tasks", tasks);
        return "listarTasks";
    }

    @RequestMapping(value = "atualizar-task", method = RequestMethod.GET)
    public String exibirPaginaDeTarefasAtualizada(@RequestParam Integer id, ModelMap modelo) {
        Task task = taskService.findById(id);
        modelo.addAttribute("task", task);
        return "task";
    }

    @RequestMapping(value = "atualizar-task", method = RequestMethod.POST)
    public String atualizarTarefa(ModelMap modelo, @Valid Task task, BindingResult resultado) {
        if(resultado.hasErrors()) {
            return "task";
        }
        String usuario = continueLogadoUsuario(modelo);
        task.setUsuario(usuario);
        taskService.atualizarTask(task);
        return "redirect:listar-tasks";
    }

    private String continueLogadoUsuario(ModelMap modelo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
