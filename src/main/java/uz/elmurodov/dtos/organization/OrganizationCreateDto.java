package uz.elmurodov.dtos.organization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.elmurodov.dtos.GenericBaseDto;



/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday  January 08 : 16
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationCreateDto implements GenericBaseDto {
    private  String name;
    private String logo;
    private String email;
    private String website;
    private String registerNum;



}
