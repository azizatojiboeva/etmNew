package uz.elmurodov.dtos.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.elmurodov.dtos.GenericBaseDto;

/**
 * @author Aziza Tojiboyeva
 * @date 20 Thursday,  January 10 : 09
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateDto implements GenericBaseDto {
   private String name;
   private String description;
   private int project_column_id ;
   private String  deadline;
   private int order;
   private int level;
   private int priority;
}
