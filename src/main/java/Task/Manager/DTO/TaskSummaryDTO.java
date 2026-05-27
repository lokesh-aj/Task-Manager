package Task.Manager.DTO;

import lombok.Data;

@Data
public class TaskSummaryDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
}
