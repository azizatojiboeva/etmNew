package uz.elmurodov.repository.auth;


import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.auth.AuthUserCreateDto;
import uz.elmurodov.dtos.auth.AuthUserUpdateDto;
import uz.elmurodov.dtos.auth.ChangePasswordDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.InfoItem;
import uz.elmurodov.security.SessionUser;
import uz.elmurodov.security.ShowUserItem;
import uz.elmurodov.utils.BaseUtils;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class AuthUserRepositoryImpl extends BaseRepository {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    public SessionUser login(String userName, String password) {
        prepareArguments(userName, password);
        String jsonDATA = (String) callProcedure(property.get("auth.login"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(jsonDATA, SessionUser.class);
    }


    public Long createUser(AuthUserCreateDto dto, int sessionId) {
        prepareArguments(BaseUtils.gson.toJson(dto), sessionId);
        String jsonData = String.valueOf(callProcedure(property.get("create.user"), Types.BIGINT));
        return BaseUtils.gson.fromJson(jsonData, Long.class);
    }

    public Boolean updateUser(AuthUserUpdateDto dto, int sessionId) {
        prepareArguments(BaseUtils.gson.toJson(dto), sessionId);
        String jsonData = String.valueOf(callProcedure(property.get("update.user"), Types.BOOLEAN));
        return BaseUtils.gson.fromJson(jsonData, Boolean.class);
    }

    public List<InfoItem> showUsers(int sessionId) {
        prepareArguments(sessionId);
        String jsonDATA = (String) callProcedure(property.get("show.users"), Types.VARCHAR);
        Type type = new TypeToken<List<ShowUserItem>>() {
        }.getType();
        List<ShowUserItem> showUserItems = BaseUtils.gson.fromJson(jsonDATA, type);
        List<InfoItem> infoItems=new ArrayList<>();
        for (int i = 0; i < showUserItems.size(); i++) {
            infoItems.add(showUserItems.get(i).getInfo());
        }
        return infoItems;
    }


    public Boolean resetPassword(ChangePasswordDto dto, int sessionId) {
        prepareArguments(BaseUtils.gson.toJson(dto), sessionId);
        return (Boolean) callProcedure(property.get("reset.password"), Types.BOOLEAN);
    }

    public Long getId(String username) {
        prepareArguments(username);
        return (Long) callProcedure(property.get("get.id"), Types.BIGINT);
    }

    public Boolean delete(long id, long sessionId){
        prepareArguments(id,sessionId);
        return (Boolean) callProcedure(property.get("delete.user"),Types.BOOLEAN);
    }



}
