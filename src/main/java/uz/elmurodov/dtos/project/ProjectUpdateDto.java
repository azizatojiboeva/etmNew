package uz.elmurodov.dtos.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.elmurodov.dtos.GenericDto;

/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday  January 14 : 48
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUpdateDto extends GenericDto {
    private String name;
    private String tz;
    private String description;
    private String background;
    private Long organization_id;
}
