package uz.elmurodov.dtos.project;

import lombok.*;
import uz.elmurodov.dtos.GenericBaseDto;

/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday  January 14 : 45
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectCreateDto implements GenericBaseDto {
    private String name;
    private String tz;
    private String description;
    private String background;
    private Long organization_id;
}
