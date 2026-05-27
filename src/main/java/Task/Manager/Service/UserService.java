package Task.Manager.Service;

import Task.Manager.DTO.TaskSummaryDTO;
import Task.Manager.DTO.UserRequestDTO;
import Task.Manager.DTO.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO requestDTO);

    UserResponseDTO getUserById(Long id);

    UserResponseDTO updateUserById(Long id, UserRequestDTO userRequestDTO);

    String deleteById(Long id);
}
