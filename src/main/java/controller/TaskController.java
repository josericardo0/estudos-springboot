package controller;

import jakarta.validation.Valid;
import model.Task;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("nome")
public class TaskController {

    public TaskController(TaskService taskService) {
        super();
        this.taskService = taskService;
    }

    private final TaskService taskService;

    @RequestMapping("listar-tasks")
    public String listarTarefas(ModelMap modelo) {
        String usuario = (String)modelo.get("nome");
        List<Task> tasks = taskService.findByUsuario(usuario);
        modelo.addAttribute("tasks", tasks);
        return "listarTasks";
    }

    @RequestMapping(value = "add-tarefa", method = RequestMethod.GET)
    public String paginaMostrarNovaTarefa(ModelMap modelo) {
        String usuario = (String)modelo.get("nome");
        Task task = new Task(0, usuario, "Descricao padrao",LocalDate.now().plusYears(1), false);
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