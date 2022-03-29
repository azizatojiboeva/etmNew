package uz.elmurodov.security;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
public class SecurityHolder {
    public static SessionUser session = null;
    public static List<PermissionsItem> permissions = new ArrayList<>();

    public static boolean hasPermission(String permission) {
        if (Objects.isNull(session))
            throw new RuntimeException("NOT_AUTHORIZED");
        if (session.isIsSuperUser()) {
            return true;
        }else {
            for (PermissionsItem sessionPermission : session.getPermissions()) {
                if (sessionPermission.getCode().equals(permission)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean hasRole(String role){
        for (RolesItem sessionRole : session.getRoles()) {
            if(sessionRole.getCode().equals(role))
                return true;
        }
        return false;
    }

    public static void setSession(SessionUser just_session) {
        permissions = just_session.getPermissions();
        session = just_session;
    }

    public static void killSession() {
        permissions = null;
        session = null;
    }


}
