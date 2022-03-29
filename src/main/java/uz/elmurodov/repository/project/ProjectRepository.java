package uz.elmurodov.repository.project;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.ResponseItem;
import uz.elmurodov.utils.BaseUtils;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;

/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday  January 13 : 07
 */
public class ProjectRepository extends BaseRepository {
    DatabaseProperties property= UNIContainer.getBean(DatabaseProperties.class);

    public Long create(ProjectCreateDto dto, int sessionId) {
        prepareArguments(BaseUtils.gson.toJson(dto), sessionId);
        return (Long) callProcedure(property.get("create.project"), Types.BIGINT);
    }

    public Boolean update(ProjectUpdateDto dto,int sessionId){
        prepareArguments(sessionId,BaseUtils.gson.toJson(dto));
        return (Boolean) callProcedure(property.get("update.project"),Types.BOOLEAN);
    }

    public Boolean delete(int projectId, int sessionId){
        prepareArguments(sessionId,projectId);
        return (Boolean) callProcedure(property.get("delete.project"),Types.BOOLEAN);
    }

    public List<ResponseItem>show(int sessionId){
        prepareArguments(sessionId);
        String jsonDATA = (String) callProcedure(property.get("project.list"), Types.VARCHAR);
        Type type = new TypeToken<List<ResponseItem>>() {
        }.getType();
        List<ResponseItem> list = BaseUtils.gson.fromJson(jsonDATA, type);
        return list;
    }

    public Boolean block(int projectId,int sessionId){
        prepareArguments(sessionId,projectId);
        return (Boolean) callProcedure(property.get("block.project"),Types.BOOLEAN);
    }

    public Boolean unBlock(int projectId,int sessionId){
        prepareArguments(sessionId,projectId);
        return (Boolean) callProcedure(property.get("unBlock.project"),Types.BOOLEAN);
    }



    public Boolean addMember(int proId, int userId, int sessionId){
        prepareArguments(proId,userId,sessionId);
        return (Boolean) callProcedure(property.get("add.project.member"),Types.BOOLEAN);
    }

    public Boolean leaveProject(int proId, int userId, int sessionId){
        prepareArguments(userId,proId,sessionId);
        return (Boolean) callProcedure(property.get("leave.project"),Types.BOOLEAN);
    }








}
