package uz.elmurodov.repository.organization;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.Info;
import uz.elmurodov.utils.BaseUtils;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;

/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday,  January 08 : 35
 */
public class OrganizationRepository extends BaseRepository {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);


    public long create(OrganizationCreateDto dto, int sessionId) {
        prepareArguments(BaseUtils.gson.toJson(dto), sessionId);
        String jsonData = String.valueOf(callProcedure(property.get("create.organization"), Types.BIGINT));
        return BaseUtils.gson.fromJson(jsonData, Long.class);
    }


    public Long getId(String name) {
        prepareArguments(name);
        String jsonData = String.valueOf(callProcedure(property.get("get.org.id"), Types.BIGINT));
        return BaseUtils.gson.fromJson(jsonData, Long.class);
    }

    public Boolean update(OrganizationUpdateDto dto, int sessionId) {
        prepareArguments(BaseUtils.gson.toJson(dto), sessionId);
        String jsonData = String.valueOf(callProcedure(property.get("update.org"), Types.BOOLEAN));
        return BaseUtils.gson.fromJson(jsonData, Boolean.class);
    }


    public Boolean block(Long orgId, int sessionId) {
        try {
            prepareArguments(orgId, sessionId);
            callProcedure(property.get("block.org"));
            return true;
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    public Boolean unBlock(Long orgId, int sessionId) {
        try {
            prepareArguments(orgId, sessionId);
            callProcedure(property.get("unblock.org"));
            return true;
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    public Boolean delete(Long orgId, int sessionId) {
        try {
            prepareArguments(orgId, sessionId);
            callProcedure(property.get("delete.org"));
            return true;
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    public void changeStatus(int status, int orgId, int sessionId) {
        try {
            prepareArguments(status, orgId, sessionId);
            callProcedure(property.get("change.status.org"));
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    public List<Info> show(int sesssionId) {
        try {
            prepareArguments(sesssionId);
            String jsonDATA = (String) callProcedure(property.get("show.organizations"), Types.VARCHAR);
            Type type = new TypeToken<List<Info>>() {
            }.getType();
            List<Info> organList = BaseUtils.gson.fromJson(jsonDATA, type);
            return organList;
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }


}
