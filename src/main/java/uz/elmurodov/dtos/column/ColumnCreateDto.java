package uz.elmurodov.dtos.column;

import lombok.*;
import uz.elmurodov.dtos.GenericBaseDto;

/**
 * @author Aziza Tojiboyeva
 * @date 20 Thursday  January 01 : 47
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColumnCreateDto implements GenericBaseDto {
   private String name;
   private Long project_id;
   private int  order;
   private String emoji;

}
