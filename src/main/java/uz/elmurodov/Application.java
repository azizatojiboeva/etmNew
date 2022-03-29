package uz.elmurodov;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.ui.MenuUi;
import uz.elmurodov.ui.admin.AdminUI;
import uz.elmurodov.ui.auth.AuthUI;
import uz.elmurodov.ui.column.ColumnUI;
import uz.elmurodov.ui.humanRes.HresUI;
import uz.elmurodov.ui.organization.OrganizationUI;
import uz.elmurodov.ui.project.ProjectUI;
import uz.elmurodov.ui.task.TaskUI;
import uz.jl.utils.Input;


public class Application {

    static MenuUi menuUi = UNIContainer.getBean(MenuUi.class);
    static AuthUI authUI = UNIContainer.getBean(AuthUI.class);
    static ProjectUI projectUI = UNIContainer.getBean(ProjectUI.class);
    static HresUI hrUI = UNIContainer.getBean(HresUI.class);
    static AdminUI adminUI = UNIContainer.getBean(AdminUI.class);
    static TaskUI taskUI = UNIContainer.getBean(TaskUI.class);
    static ColumnUI columnUI = UNIContainer.getBean(ColumnUI.class);
    static OrganizationUI organizationUI = UNIContainer.getBean(OrganizationUI.class);


    public static void main(String[] args) {
        menuUi.getMainMenu();
        String choice = Input.getStr("Your choice: ");
        switch (choice.toUpperCase()) {
            case "LOGIN" -> authUI.login();
            case "CREATE_USER" -> authUI.createUser();
            case "UPDATE_USER" -> authUI.updateUser();
            case "DELETE_USER" -> authUI.deleteUser();
            case "SEE_USERS" -> authUI.showUsers();

            case "ASSIGN_ROLE_TO_USER"->adminUI.assignRole();// TODO: 1/20/2022 bajar
            case "ASSIGN_PERMISSION"->adminUI.assignPermission();// TODO: 1/20/2022 bajar


            case "CREATE_PROJECT" -> projectUI.createProject();
            case "UPDATE_PROJECT" -> projectUI.updateProject();
            case "DELETE_PROJECT" -> projectUI.deleteProject();
            case "PROJECT_DETAIL", "PROJECT_LIST" -> projectUI.projectList();
            case "PROJECT_BLOCK" -> projectUI.projectBlock();
            case "PROJECT_UNBLOCK" -> projectUI.projectUnBlock();


            case "ADD_PROJECT_MEMBER"->projectUI.addMember();
            case "REMOVE_PROJECT_MEMBER"->projectUI.leaveProject();


            case "CREATE_COLUMN" -> columnUI.createColumn();
            case "UPDATE_COLUMN" -> columnUI.updateColumn();
            case "DELETE_COLUMN" -> columnUI.deleteColumn();


            case "CREATE_EMPLOYEE"->hrUI.createEmployee();
            case "UPDATE_EMPLOYEE"->hrUI.updateEmployee();
            case "DELETE_EMPLOYEE"->hrUI.deleteEmployee();


            case "CREATE_ORGANIZATION"->organizationUI.createOrg();
            case "BLOCK_ORGANIZATION"->organizationUI.blockOrg();
            case "UNBLOCK_ORGANIZATION"->organizationUI.unBlockOrg();
            case "DELETE_ORGANIZATION"->organizationUI.deleteOrg();
            case "SEE_ORGANIZATIONS"->organizationUI.showOrg();
            case "UPDATE_ORGANIZATION"->organizationUI.updateOrg();
            case "UPDATE_ORGANIZATION_STATUS"->organizationUI.changeStatus();

            case "TASK_CREATE"->taskUI.create();
            case "TASK_UPDATE"->taskUI.update();
            case "LEAVE_COMMENT"->taskUI.leaveComment();


            case "RESET_PASSWORD"->authUI.resetPassword();
            case "SEE_PROFILE"->authUI.showProfile();
            case "LOGOUT" -> authUI.logout();
        }
        main(args);

    }

}
