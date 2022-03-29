package uz.elmurodov.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.elmurodov.dtos.GenericDto;

/**
 * @author Aziza Tojiboyeva
 * @date 18 Tuesday  January 09 : 12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserUpdateDto extends GenericDto {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public AuthUserUpdateDto(Long id, String username,
                             String email, String firstname,
                             String lastname, String phoneNumber) {
        super(id);
        this.username = username;
        this.email = email;
        this.firstName = firstname;
        this.lastName = lastname;
        this.phoneNumber = phoneNumber;
    }


}
