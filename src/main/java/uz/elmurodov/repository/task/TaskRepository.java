package uz.elmurodov.repository.task;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.task.CommentDto;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;

/**
 * @author Aziza Tojiboyeva
 * @date 20 Thursday  January 10 : 39
 */
public class TaskRepository extends BaseRepository {
    DatabaseProperties properties = UNIContainer.getBean(DatabaseProperties.class);


    public Long create(TaskCreateDto dto, int sessionId) {
        prepareArguments(BaseUtils.gson.toJson(dto), sessionId);
        return (Long) callProcedure(properties.get("task.create"), Types.BIGINT);
    }

    public Boolean update(TaskUpdateDto dto, int sessionId) {
        prepareArguments(BaseUtils.gson.toJson(dto), sessionId);
        return (Boolean) callProcedure(properties.get("task.update"), Types.BOOLEAN);
    }

    public void delete(int taskId, int sessionId) {
        prepareArguments(sessionId, taskId);
        callProcedure(properties.get("task.delete"));
    }


    public Long addMember(int userId, int taskId, int sessionid) {
        prepareArguments(userId, taskId, sessionid);
        return (Long) callProcedure(properties.get("add.task.member"), Types.BIGINT);
    }

    public Long leaveComment(CommentDto dto, int sessionId){
        prepareArguments(BaseUtils.gson.toJson(dto),sessionId);
        return (Long) callProcedure(properties.get("leave.comment"),Types.BIGINT);
    }


}
