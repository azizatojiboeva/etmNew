package uz.elmurodov.dtos.organization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.utils.Point;

/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday  January 08 : 17
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationUpdateDto extends GenericDto {
   private String website;
   private String email;
   private String logo ;
    private Point location;

}


