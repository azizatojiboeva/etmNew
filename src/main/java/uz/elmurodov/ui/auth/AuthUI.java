package uz.elmurodov.ui.auth;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.auth.AuthUserCreateDto;
import uz.elmurodov.dtos.auth.AuthUserUpdateDto;
import uz.elmurodov.dtos.auth.ChangePasswordDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.InfoItem;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.ui.BaseAbstractUI;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.List;

import static uz.elmurodov.security.SecurityHolder.session;
import static uz.jl.utils.Input.getNum;
import static uz.jl.utils.Input.getStr;

/**
 * @author Aziza Tojiboyeva
 * @date 17 Monday  January 12 : 20
 */

public class AuthUI extends BaseAbstractUI {
    AuthUserService authUserService = UNIContainer.getBean(AuthUserService.class);


    public void login() {
        String username = getStr("Username: ");
        String password = getStr("Password: ");
        ResponseEntity<Data<?>> response = authUserService.login(username, password);
        show(response);
    }

    public void createUser() {
        try {
            if (SecurityHolder.hasPermission("CREATE_USER")) {
                String username = getStr("Username: ");
                String password = getStr("Password: ");
                String phone = getStr("Phone: ");
                String firstName = getStr("FirstName: ");
                String lastName = getStr("LastName: ");
                String email = getStr("Email: ");
                AuthUserCreateDto authUserCreateDto = AuthUserCreateDto.builder()
                        .username(username)
                        .password(password)
                        .phone(phone)
                        .firstName(firstName)
                        .lastName(lastName)
                        .email(email)
                        .organizationId(session.getOrganization().getId())
                        .build();
                ResponseEntity<Data<?>> response = authUserService.create(authUserCreateDto);
                show(response);
            } else {
                ResponseEntity<Data<String>> response = new ResponseEntity<>(new Data<>("Permission_denied"));
                show(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser() {
        try {
            SecurityHolder.hasPermission("UPDATE_USER");
            AuthUserUpdateDto dto = new AuthUserUpdateDto();
            String oldName = getStr("Enter username to  find the in order to update credentials: ");
            try {
                Long id = authUserService.getId(oldName);
                dto.setId(id);
            } catch (CustomerSQLException e) {
                e.printStackTrace();
            }
            String choice = getStr("Want to update username ? (yes/no) ");
            String uname = oldName;
            if (choice.startsWith("y")) {
                uname = getStr("Username: ");
            }
            String email = null;
            String choice1 = getStr("Want to update email ? (yes/no) ");
            if (choice1.startsWith("y")) {
                email = getStr("Email: ");
            }
            String phoneNumber = null;
            String choice2 = getStr("Want to update phoneNUmber ? (yes/no) ");
            if (choice2.startsWith("y")) {
                phoneNumber = getStr("phoneNumber: ");
            }
            String firstname = null;
            String choice3 = getStr("Want to update firstName ? (yes/no) ");
            if (choice3.startsWith("y")) {
                firstname = getStr("firstName: ");
            }
            String lastName = null;
            String choice4 = getStr("Want to update lastName ? (yes/no) ");
            if (choice4.startsWith("y")) {
                lastName = getStr("lastName: ");
            }
            dto.setUsername(uname);
            dto.setEmail(email);
            dto.setFirstName(firstname);
            dto.setLastName(lastName);
            dto.setPhoneNumber(phoneNumber);
            ResponseEntity<Data<?>> response = authUserService.update(dto);
            show(response);

        } catch (Exception e) {
            show(e);
        }
    }

    public void deleteUser() {
        try {
            SecurityHolder.hasPermission("DELETE_USER");
            int id=getNum("Enter user id to delete: ");
            ResponseEntity<Data<?>>response=authUserService.delete(id);
            show(response);
        } catch (Exception e) {
            show(e);
        }
    }

    public void showUsers() {
        try {
            SecurityHolder.hasPermission("SEE_USERS");
            ResponseEntity<Data<List<InfoItem>>>response=authUserService.showUsers();
            List<InfoItem> list=response.getBody().getData();
            int count=1;
            Print.println(Color.RED,"=========USERS========");
            for (int i = 0; i < list.size(); i++) {
                Print.println(Color.CYAN,(count++)+" -> USER ");
                Print.println(Color.PURPLE,"Id: "+list.get(i).getId());
                Print.println(Color.PURPLE,"Username: "+list.get(i).getUsername());
                Print.println(Color.PURPLE,"First Name: "+list.get(i).getFirstname());
                Print.println(Color.PURPLE,"Last name: "+list.get(i).getLastname());
                Print.println(Color.PURPLE,"Language: "+list.get(i).getLanguage());
                Print.println(Color.PURPLE,"Phone: "+list.get(i).getPhone());
                Print.println(Color.PURPLE,"Email: "+list.get(i).getEmail());
            }
        } catch (Exception e) {
            show(e);
        }
    }

    public void resetPassword() {
        String oldName = getStr("Enter username to reset password : ");
        ChangePasswordDto dto = new ChangePasswordDto();
        try {
            Long id = authUserService.getId(oldName);
            dto.setId(id);
        } catch (CustomerSQLException e) {
            e.printStackTrace();
        }
        String oldPass = getStr("Enter old password: ");
        dto.setOldPassword(oldPass);
        String newPass = getStr("Enter new password: ");
        dto.setNewPassword(newPass);
        String conPass = getStr("Confirm new Password: ");
        dto.setConfirmNewPassword(conPass);
        ResponseEntity<Data<?>> response = authUserService.resetPassword(dto);
        show(response);
    }


    public void showProfile() {
        Print.println(Color.BLUE,"========USER=======");
        Print.println(Color.CYAN,"ID: "+session.getId());
        Print.println(Color.CYAN,"Username: "+session.getUsername());
        Print.println(Color.CYAN,"FirstName: "+session.getFirstName());
        Print.println(Color.CYAN,"LastName: "+session.getLastName());
        Print.println(Color.CYAN,"Role: "+session.getRoles().get(0).getName());
        Print.println(Color.CYAN,"Language: "+session.getLanguage());
        Print.println(Color.CYAN,"PhoneNumber: "+session.getPhone());
        Print.println(Color.CYAN,"Code: "+session.getCode());
        Print.println(Color.CYAN,"Email: "+session.getEmail());
    }

    public void logout() {
        Print.println("Bye");
        SecurityHolder.killSession();
    }

}



