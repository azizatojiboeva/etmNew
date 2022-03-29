package uz.elmurodov.services.project;

import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.project.ProjectRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.ResponseItem;
import uz.elmurodov.services.BaseService;

import java.util.List;

import static uz.elmurodov.security.SecurityHolder.hasPermission;
import static uz.elmurodov.security.SecurityHolder.session;

/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday  January 13 : 04
 */
public class ProjectService extends BaseService<ProjectRepository,
        ProjectCreateDto,
        ProjectDto,
        ProjectUpdateDto,
        Long> {

    public ProjectService(ProjectRepository repository) {
        super(repository);
    }


    @Override
    public ResponseEntity<Data<?>> create(ProjectCreateDto dto) {
        try {
            hasPermission("CREATE_PROJECT");
            Long res = repository.create(dto, session.getId());
            return new ResponseEntity<>(new Data<>(res));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }

    }

    @Override
    public ResponseEntity<Data<?>> update(ProjectUpdateDto dto) {
        try{
            hasPermission("UPDATE_PROJECT");
            Boolean res=repository.update(dto,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }

    public ResponseEntity<Data<?>> delete(int projectId){
        try{
            hasPermission("DELETE_PROJECT");
            Boolean res=repository.delete(projectId,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }

    public ResponseEntity<Data<List<ResponseItem>>> show(){
        try {
            hasPermission("PROJECT_LIST");
            List<ResponseItem > list=repository.show(session.getId());
            return new ResponseEntity<>(new Data<>(list));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }

    public ResponseEntity<Data<?>> block(int projectId){
        try{
            hasPermission("PROJECT_BLOCK");
            Boolean res=repository.block(projectId,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }

    public ResponseEntity<Data<?>> unBlock(int projectId){
        try{
            hasPermission("PROJECT_UNBLOCK");
            Boolean res=repository.unBlock(projectId,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }

    public ResponseEntity<Data<?>> addMember(int proId, int userId){
        try{
            hasPermission("ADD_PROJECT_MEMBER");
            Boolean res=repository.addMember(proId,userId,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }

    public ResponseEntity<Data<?>> leaveProject(int proId, int userId){
        try{
            hasPermission("LEAVE_PROJECT");
            Boolean res=repository.leaveProject(proId,userId,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            throw new CustomerSQLException(e.getFriendlyMessage(),e.getCause());
        }
    }


    @Override
    public ResponseEntity<ProjectDto> get(Long id) {
        return null;
    }


}
