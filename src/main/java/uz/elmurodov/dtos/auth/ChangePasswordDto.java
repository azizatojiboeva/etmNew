package uz.elmurodov.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.elmurodov.dtos.GenericDto;

/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday  January 00 : 37
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordDto extends GenericDto {
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

}
