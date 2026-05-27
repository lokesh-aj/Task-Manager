package Task.Manager.Controller;

import Task.Manager.DTO.UserRequestDTO;
import Task.Manager.DTO.UserResponseDTO;
import Task.Manager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO requestDTO){
        return userService.createUser(requestDTO);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUserById(@PathVariable Long id,@RequestBody UserRequestDTO requestDTO){
        return userService.updateUserById(id,requestDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id){
        return userService.deleteById(id);
    }
}
