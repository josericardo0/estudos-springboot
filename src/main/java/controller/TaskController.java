package controller;

import model.Task;
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
    List<Task> tasks = taskService.findByUsuario("Zecardinho");
    modelo.addAttribute("tasks", tasks);
    return "listarTasks";

    }

    @RequestMapping(value = "add-tarefa", method = RequestMethod.GET)
    public String paginaMostrarNovaTarefa() {
        return "task";
    }

    @RequestMapping(value = "add-tarefa", method = RequestMethod.POST)
    public String adicionarTarefa(@RequestParam String descricao, ModelMap modelo) {
        String usuario = (String)modelo.get("nome");
        taskService.addTask(usuario, descricao, LocalDate.now().plusYears(1), false);
        return "redirect:listar-tasks";
    }


}