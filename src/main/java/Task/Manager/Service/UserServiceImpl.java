package Task.Manager.Service;

import Task.Manager.DTO.TaskSummaryDTO;
import Task.Manager.DTO.UserRequestDTO;
import Task.Manager.DTO.UserResponseDTO;
import Task.Manager.Entity.Task;
import Task.Manager.Entity.User;
import Task.Manager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserResponseDTO createUser(UserRequestDTO requestDTO) {
        User user = new User();

        user.setUsername(requestDTO.getUsername());

        User savedData = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();

        response.setId(savedData.getId());
        response.setUsername(savedData.getUsername());

        return response;
    }

    @Override
    public UserResponseDTO updateUserById(Long id, UserRequestDTO userRequestDTO) {

        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));

        user.setUsername(userRequestDTO.getUsername());

        User savedData = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();

        response.setId(savedData.getId());
        response.setUsername(savedData.getUsername());

        return response;
    }

    @Override
    public String deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));

        userRepository.delete(user);

        return "User deleted successfully";
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User data = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));

        UserResponseDTO response = new UserResponseDTO();

        response.setId(data.getId());
        response.setUsername(data.getUsername());

        List<Task> tasks = data.getTasks();

        List<TaskSummaryDTO> responseTasks = new ArrayList<>();

        for(Task task: tasks){
            TaskSummaryDTO taskSummaryDTO = new TaskSummaryDTO();
            taskSummaryDTO.setId(task.getId());
            taskSummaryDTO.setTitle(task.getTitle());
            taskSummaryDTO.setDescription(task.getDescription());
            taskSummaryDTO.setStatus(task.getStatus());

            responseTasks.add(taskSummaryDTO);
        }

        response.setTasks(responseTasks);

        return response;
    }
}
