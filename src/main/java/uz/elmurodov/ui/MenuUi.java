package uz.elmurodov.ui;

import uz.elmurodov.security.PermissionsItem;
import uz.elmurodov.security.SecurityHolder;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.Objects;

import static uz.elmurodov.security.SecurityHolder.permissions;

public class MenuUi {

    public void getMainMenu() {
        Print.println(Color.YELLOW,"===============MENU============");
        Print.println("");
        if (Objects.isNull(SecurityHolder.session)) {
            Print.println(Color.BLUE, "Login -> LOGIN");
            Print.println(Color.BLUE, "Exit -> EXIT");
        } else {
            if (Objects.nonNull(permissions)) {
                for (PermissionsItem permission : permissions) {
                    Print.println(Color.BLUE, permission.getName() + " -> " + permission.getCode());
                }
            }
            Print.println("Reset password -> RESET_PASSWORD");
            Print.println("See profile -> SEE_PROFILE");
            Print.println("Logout -> LOGOUT");
        }


    }
}
