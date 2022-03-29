package uz.elmurodov.dtos.column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.elmurodov.dtos.GenericDto;

/**
 * @author Aziza Tojiboyeva
 * @date 20 Thursday  January 01 : 47
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ColumnUpdateDto extends GenericDto {
    private String name;
    private String emoji;
    private int order;
    private long column_id;

}
