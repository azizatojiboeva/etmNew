package uz.elmurodov.dtos.auth;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.dtos.GenericBaseDto;


@Getter
@Setter
@Builder
public class AuthUserCreateDto implements GenericBaseDto {
    private String username;
    private String password;
    private String phone;
    private int organizationId;
    private String firstName;
    private String lastName;
    private String language;
    private String email;

}
