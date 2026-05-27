package Task.Manager.Controller;

import Task.Manager.DTO.TaskRequestDTO;
import Task.Manager.DTO.TaskResponseDTO;
import Task.Manager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create-task/{userId}")
    public TaskResponseDTO createTask(@PathVariable Long userId,@RequestBody TaskRequestDTO requestDTO){
        return taskService.createTask(userId,requestDTO);
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @GetMapping("/show-all-tasks")
    public List<TaskResponseDTO> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public TaskResponseDTO updateTaskById(@PathVariable Long id, @RequestBody TaskRequestDTO requestDTO){
        return taskService.updateTask(id,requestDTO);
    }
    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable Long id){
        return taskService.deleteTaskById(id);
    }
}
