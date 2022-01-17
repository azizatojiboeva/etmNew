package uz.elmurodov.repository.auth;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.SessionUser;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;

public class AuthUserRepositoryImpl extends BaseRepository {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    public SessionUser login(String userName, String password) {
        prepareArguments(userName,password);
        String jsonDATA = (String) callProcedure(property.get("auth.login"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(jsonDATA, SessionUser.class);
    }

}
