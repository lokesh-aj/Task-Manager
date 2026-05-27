package Task.Manager.DTO;

import Task.Manager.Entity.Task;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private Long id;

    private String username;

    private List<TaskSummaryDTO> tasks;
}
