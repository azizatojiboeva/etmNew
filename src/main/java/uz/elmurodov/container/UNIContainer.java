package uz.elmurodov.container;

import uz.elmurodov.property.ApplicationProperties;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.auth.AuthUserRepositoryImpl;
import uz.elmurodov.repository.column.ColumnRepository;
import uz.elmurodov.repository.organization.OrganizationRepository;
import uz.elmurodov.repository.project.ProjectRepository;
import uz.elmurodov.repository.task.TaskRepository;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.services.column.ColumnService;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.services.project.ProjectService;
import uz.elmurodov.services.task.TaskService;
import uz.elmurodov.ui.MenuUi;
import uz.elmurodov.ui.admin.AdminUI;
import uz.elmurodov.ui.auth.AuthUI;
import uz.elmurodov.ui.column.ColumnUI;
import uz.elmurodov.ui.humanRes.HresUI;
import uz.elmurodov.ui.organization.OrganizationUI;
import uz.elmurodov.ui.project.ProjectUI;
import uz.elmurodov.ui.task.TaskUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class UNIContainer {
    private static final ApplicationProperties APPLICATION_PROPERTIES;
    private static final DatabaseProperties DATABASE_PROPERTIES;
    private static Connection CONNECTION;
    private final static AuthUserRepositoryImpl AUTH_USER_REPOSITORY;
    private final static AuthUserService AUTH_USER_SERVICE;
    private final static OrganizationRepository ORGANIZATION_REPOSITORY;
    private final static ProjectRepository PROJECT_REPOSITORY;
    private final static ColumnRepository COLUMN_REPOSITORY;
    private final static TaskRepository TASK_REPOSITORY;
    private final static OrganizationService ORGANIZATION_SERVICE;
    private final static ProjectService PROJECT_SERVICE;
    private final static ColumnService COLUMN_SERVICE;
    private final static MenuUi MENU_UI;
    private final static AuthUI AUTH_UI;
    private final static ProjectUI PROJECT_UI;
    private final static HresUI HRES_UI;
    private final static AdminUI ADMIN_UI;
    private final static TaskUI TASK_UI;
    private final static TaskService TASK_SERVICE;
    private final static ColumnUI COLUMN_UI;
    private final static OrganizationUI ORGANIZATION_UI;



    static {
        APPLICATION_PROPERTIES = new ApplicationProperties();
        DATABASE_PROPERTIES = new DatabaseProperties();
        try {
            CONNECTION = DriverManager.getConnection(
                    APPLICATION_PROPERTIES.get("db.jdbc"),
                    APPLICATION_PROPERTIES.get("db.username"),
                    APPLICATION_PROPERTIES.get("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AUTH_USER_REPOSITORY = new AuthUserRepositoryImpl();
        AUTH_USER_SERVICE = new AuthUserService(AUTH_USER_REPOSITORY);
        ORGANIZATION_REPOSITORY=new OrganizationRepository();
        PROJECT_REPOSITORY=new ProjectRepository();
        TASK_REPOSITORY=new TaskRepository();
        ORGANIZATION_SERVICE=new OrganizationService();
        COLUMN_REPOSITORY=new ColumnRepository();
        COLUMN_SERVICE=new ColumnService();
        TASK_SERVICE=new TaskService();
        PROJECT_SERVICE=new ProjectService(PROJECT_REPOSITORY);
        MENU_UI = new MenuUi();
        AUTH_UI=new AuthUI();
        PROJECT_UI=new ProjectUI();
        HRES_UI=new HresUI();
        ADMIN_UI=new AdminUI();
        TASK_UI=new TaskUI();
        COLUMN_UI=new ColumnUI();
        ORGANIZATION_UI=new OrganizationUI();
    }

    public static <T> T getBean(Class<T> bean) {
        return getBean(bean.getSimpleName().toUpperCase(Locale.ROOT));
    }

    public static <T> T getBean(String bean) {
        bean = bean.toUpperCase(Locale.ROOT);
        return switch (bean) {
            case "APPLICATIONPROPERTIES" -> (T) APPLICATION_PROPERTIES;
            case "DATABASEPROPERTIES" -> (T) DATABASE_PROPERTIES;
            case "CONNECTION" -> (T) CONNECTION;
            case "MENUUI"->(T)MENU_UI;
            case "AUTHUSERSERVICE" -> (T) AUTH_USER_SERVICE;
            case "AUTHUSERREPOSITORY" -> (T) AUTH_USER_REPOSITORY;
            case "ORGANIZATIONSERVICE"->(T)ORGANIZATION_SERVICE;
            case "ORGANIZATIONREPOSITORY"->(T)ORGANIZATION_REPOSITORY;
            case "PROJECTREPOSITORY"->(T)PROJECT_REPOSITORY;
            case "COLUMNREPOSITORY"->(T)COLUMN_REPOSITORY;
            case "TASKREPOSITORY"->(T)TASK_REPOSITORY;
            case "AUTHUI"->(T)AUTH_UI;
            case "PROJECTUI"->(T)PROJECT_UI;
            case "HRESUI"->(T)HRES_UI;
            case "ADMINUI"->(T)ADMIN_UI;
            case "ORGANIZATIONUI"->(T)ORGANIZATION_UI;
            case "TASKUI"->(T)TASK_UI;
            case "COLUMNUI"->(T)COLUMN_UI;
            case "PROJECTSERVICE"->(T)PROJECT_SERVICE;
            case "COLUMNSERVICE"->(T)COLUMN_SERVICE;
            case "TASKSERVICE"->(T)TASK_SERVICE;
            default -> throw new RuntimeException("Bean Not Found");
        };
    }


}
