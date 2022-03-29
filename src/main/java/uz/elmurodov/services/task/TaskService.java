package uz.elmurodov.services.task;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.task.CommentDto;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.task.TaskRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.BaseService;

import static uz.elmurodov.security.SecurityHolder.session;

/**
 * @author Aziza Tojiboyeva
 * @date 20 Thursday  January 10 : 38
 */

public class TaskService extends BaseService<
        TaskRepository,
        TaskCreateDto,
        TaskDto,
        TaskUpdateDto,
        Long> {

    TaskRepository repository = UNIContainer.getBean(TaskRepository.class);


    @Override
    public ResponseEntity<Data<?>> create(TaskCreateDto dto) {
        try {
            SecurityHolder.hasPermission("TASK_CREATE");
            Long res =repository.create(dto,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }

    @Override
    public ResponseEntity<Data<?>> update(TaskUpdateDto dto) {
        try {
            SecurityHolder.hasPermission("TASK_UPDATE");
            Boolean res=repository.update(dto,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }

    public ResponseEntity<Data<Boolean>> delete(int taskId){
        try{
            SecurityHolder.hasPermission("TASK_DELETE");
            repository.delete(taskId,session.getId());
            return new ResponseEntity<>(new Data<>(true));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }

    public ResponseEntity<Data<Long>> addMember(int taskId, int userId){
        try {
            SecurityHolder.hasPermission("ADD_TASK_MEMBER");
            Long res=repository.addMember(userId,taskId,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }

    public ResponseEntity<Data<Long>>leaveComment(CommentDto dto){
        try {
            SecurityHolder.hasPermission("LEAVE_COMMENT");
            Long res=repository.leaveComment(dto,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            throw e;
        }
    }




    @Override
    public ResponseEntity<TaskDto> get(Long id) {
        return null;
    }
}
