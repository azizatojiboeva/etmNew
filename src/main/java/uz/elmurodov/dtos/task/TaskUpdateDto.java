package uz.elmurodov.dtos.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.elmurodov.dtos.GenericDto;

/**
 * @author Aziza Tojiboyeva
 * @date 20 Thursday  January 10 : 12
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateDto extends GenericDto {
   private String name;
   private String description;
   private int project_column_id;
   private String deadline;
   private int order;
   private int level;
   private int priority;

}
