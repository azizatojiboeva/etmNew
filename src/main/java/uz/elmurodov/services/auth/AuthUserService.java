package uz.elmurodov.services.auth;

import uz.elmurodov.dtos.auth.AuthUserCreateDto;
import uz.elmurodov.dtos.auth.AuthUserDto;
import uz.elmurodov.dtos.auth.AuthUserUpdateDto;
import uz.elmurodov.dtos.auth.ChangePasswordDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.auth.AuthUserRepositoryImpl;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.InfoItem;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.BaseService;

import java.util.List;

import static uz.elmurodov.security.SecurityHolder.hasPermission;
import static uz.elmurodov.security.SecurityHolder.session;

public class AuthUserService extends BaseService<AuthUserRepositoryImpl,
        AuthUserCreateDto,
        AuthUserDto,
        AuthUserUpdateDto,
        Long> {

    public AuthUserService(AuthUserRepositoryImpl repository) {
        super(repository);
    }

    public ResponseEntity<Data<?>> login(String userName, String password) {
        try {
            SecurityHolder.session = repository.login(userName, password);
            SecurityHolder.setSession(session);
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> create(AuthUserCreateDto dto) {
        try {
            hasPermission("CREATE_USER");
            Long res = repository.createUser(dto, session.getId());
            return new ResponseEntity<>(new Data<>(res));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> update(AuthUserUpdateDto dto) {
        try {
            hasPermission("UPDATE_USER");
            Boolean res = repository.updateUser(dto, session.getId());
            return new ResponseEntity<>(new Data<>(res));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<AuthUserDto> get(Long id) {
        try {
            hasPermission("CREATE_ORGANIZATION");
            return null;
        } catch (Exception e) {
            return null;
        }
    }


    public ResponseEntity<Data<List<InfoItem>>> showUsers() {
        try {
            hasPermission("SEE_USERS");
            List<InfoItem> showUser = repository.showUsers(session.getId());
            return new ResponseEntity<>(new Data<>(showUser));
        } catch (CustomerSQLException e) {
           throw e;
        }
    }


    public ResponseEntity<Data<?>> resetPassword(ChangePasswordDto dto){
        try {
            SecurityHolder.hasPermission("RESET_PASSWORD");
               Boolean res=repository.resetPassword(dto,session.getId());
               return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    public ResponseEntity<Data<?>> delete(long id){
        try {
            SecurityHolder.hasPermission("DELETE_USER");
            Boolean res=repository.delete(id,session.getId());
            return new ResponseEntity<>(new Data<>(res));
        }catch (CustomerSQLException e){
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()),e.getStatus());
        }
    }



    public Long getId(String uname) {
        return repository.getId(uname);
    }


}
