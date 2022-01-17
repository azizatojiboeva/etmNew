package uz.elmurodov.ui;

import uz.elmurodov.security.PermissionsItem;
import uz.elmurodov.security.SecurityHolder;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.List;
import java.util.Objects;

import static uz.elmurodov.security.SecurityHolder.hasPermission;
import static uz.elmurodov.security.SecurityHolder.permissions;

public class Menu {


    public static void getMainMenu() {
        if (Objects.isNull(SecurityHolder.session)) {
            Print.print(Color.BLUE, "Login -> LOGIN");
        } else {
            for (PermissionsItem permission : permissions) {
                Print.print(Color.BLUE, permission.getName() + " -> " + permission.getCode());
            }
            Print.print("Logout -> LOGOUT");
        }
        Print.print(Color.BLUE, "Exit -> EXIT");

    }
}
