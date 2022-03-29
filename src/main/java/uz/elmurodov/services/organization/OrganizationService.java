package uz.elmurodov.services.organization;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationDto;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.organization.OrganizationRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.Info;
import uz.elmurodov.services.BaseService;

import java.util.List;

import static uz.elmurodov.security.SecurityHolder.hasPermission;
import static uz.elmurodov.security.SecurityHolder.session;


/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday  January 08 : 19
 */
public class OrganizationService extends BaseService<OrganizationRepository,
        OrganizationCreateDto, OrganizationDto,
        OrganizationUpdateDto, Long> {
    OrganizationRepository repository = UNIContainer.getBean(OrganizationRepository.class);



    @Override
    public ResponseEntity<Data<?>> create(OrganizationCreateDto dto) {
        try {
            hasPermission("CREATE_ORGANIZATION");
            Long res = repository.create(dto, session.getId());
            return new ResponseEntity<>(new Data<>(res));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> update(OrganizationUpdateDto dto) {
        try {
            hasPermission("UPDATE_ORGANIZATION");
            Boolean res = repository.update(dto, session.getId());
            return new ResponseEntity<>(new Data<>(res));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<OrganizationDto> get(Long id) {
        return null;
    }

    public ResponseEntity<Data<Object>> block(Long orgId) {
        try {
            hasPermission("BLOCK_ORGANIZATION");
            Boolean res = repository.block(orgId, session.getId());
            return new ResponseEntity<>(new Data<>(res));
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    public ResponseEntity<Data<Object>> unBlock(Long orgId) {
        try {
            hasPermission("UNBLOCK_ORGANIZATION");
            Boolean res = repository.unBlock(orgId, session.getId());
            return new ResponseEntity<>(new Data<>(res));
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    public ResponseEntity<Data<Boolean>> delete(Long orgId) {
        try {
            hasPermission("DELETE_ORGANIZATION");
            repository.delete(orgId, session.getId());
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    public ResponseEntity<Data<Boolean>> changeStatus(int status, int orgId) {
        try {
            hasPermission("CHANGE_ORG_STATUS");
            repository.changeStatus(status, orgId, session.getId());
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    public ResponseEntity<Data<List<Info>>> showList() {
        try {
            hasPermission("SEE_ORGANIZATIONS");
            List<Info> itemList = repository.show(session.getId());
            return new ResponseEntity<>(new Data<>(itemList));
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    public Long getId(String name) {
        return repository.getId(name);
    }

}
