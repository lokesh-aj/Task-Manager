package Task.Manager.Service;

import Task.Manager.DTO.TaskRequestDTO;
import Task.Manager.DTO.TaskResponseDTO;

import java.util.List;

public interface TaskService {

    TaskResponseDTO createTask(Long userId, TaskRequestDTO requestDTO);

    TaskResponseDTO getTaskById(Long id);

    List<TaskResponseDTO> getAllTasks();

    TaskResponseDTO updateTask(Long Id, TaskRequestDTO requestDTO);

    String deleteTaskById(Long id);


}
