package Task.Manager.Service;

import Task.Manager.DTO.TaskRequestDTO;
import Task.Manager.DTO.TaskResponseDTO;
import Task.Manager.Entity.Task;
import Task.Manager.Entity.User;
import Task.Manager.Repository.TaskRepository;
import Task.Manager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskResponseDTO createTask(Long userId,TaskRequestDTO requestDTO) {

        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));

        Task task = new Task();
        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());
        task.setStatus("TODO");
        task.setUser(user);

        Task savedData = taskRepository.save(task);

        TaskResponseDTO response = new TaskResponseDTO();

        response.setId(savedData.getId());
        response.setTitle(savedData.getTitle());
        response.setDescription(savedData.getDescription());
        response.setStatus(savedData.getStatus());


        return response;
    }

    @Override
    public String deleteTaskById(Long id) {

        Task task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found"));

        taskRepository.delete(task);

        return "Task deleted successfully";
    }

    @Override
    public TaskResponseDTO updateTask(Long Id, TaskRequestDTO requestDTO) {
        Task task = taskRepository.findById(Id).orElseThrow(()->new RuntimeException("User not found"));

        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());

        Task savedData = taskRepository.save(task);

        TaskResponseDTO response = new TaskResponseDTO();

        response.setId(savedData.getId());
        response.setTitle(savedData.getTitle());
        response.setDescription(savedData.getDescription());
        response.setStatus(savedData.getStatus());


        return response;
    }

    @Override
    public TaskResponseDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found"));

        TaskResponseDTO response = new TaskResponseDTO();

        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setStatus(task.getStatus());

        return response;
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponseDTO> responses = new ArrayList<>();

        for(Task data:tasks){
            TaskResponseDTO response = new TaskResponseDTO();
            response.setId(data.getId());
            response.setTitle(data.getTitle());
            response.setDescription(data.getDescription());
            response.setStatus(data.getStatus());

            responses.add(response);
        }
        return responses;
    }
}
