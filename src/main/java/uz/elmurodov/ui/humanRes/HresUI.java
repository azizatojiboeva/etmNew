package uz.elmurodov.ui.humanRes;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.ui.BaseAbstractUI;
import uz.elmurodov.ui.auth.AuthUI;

/**
 * @author Aziza Tojiboyeva
 * @date 18 Tuesday  January 23 : 34
 */

public class HresUI extends BaseAbstractUI {
    AuthUI authUI = UNIContainer.getBean(AuthUI.class);

    public void createEmployee() {
        try {
            SecurityHolder.hasRole("HR");
            authUI.createUser();
        } catch (Exception e) {
            show(e);
        }
    }

    public void updateEmployee() {
        try {
            SecurityHolder.hasRole("HR");
            authUI.updateUser();
        } catch (Exception e) {
            show(e);
        }
    }

    public void deleteEmployee() {
        try {
            SecurityHolder.hasRole("HR");
            authUI.deleteUser();
        } catch (Exception e) {
            show(e);
        }
    }


}
