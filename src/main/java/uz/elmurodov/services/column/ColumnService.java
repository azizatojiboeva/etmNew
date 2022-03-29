package uz.elmurodov.services.column;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnDto;
import uz.elmurodov.dtos.column.ColumnUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.column.ColumnRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.BaseService;

import static uz.elmurodov.security.SecurityHolder.hasPermission;
import static uz.elmurodov.security.SecurityHolder.session;

/**
 * @author Aziza Tojiboyeva
 * @date 20 Thursday  January 01 : 54
 */

public class ColumnService extends BaseService<
        ColumnRepository,
        ColumnCreateDto,
        ColumnDto,
        ColumnUpdateDto,
        Long> {

    ColumnRepository repository= UNIContainer.getBean(ColumnRepository.class);


    @Override
    public ResponseEntity<Data<?>> create(ColumnCreateDto dto) {
        try {
            hasPermission("CREATE_COLUMN");
            Long id = repository.create(dto, session.getId());
            return new ResponseEntity<>(new Data<>(id));
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    @Override
    public ResponseEntity<Data<?>> update(ColumnUpdateDto dto) {
        try {
            hasPermission("UPDATE_COLUMN");
            Boolean res = repository.update(dto, session.getId());
            return new ResponseEntity<>(new Data<>(res));
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }

    public ResponseEntity<Data<?>> delete(int id) {
        try {
            hasPermission("DELETE_COLUMN");
            Boolean res = repository.delete(id, session.getId());
            return new ResponseEntity<>(new Data<>(res));
        } catch (CustomerSQLException e) {
            throw new CustomerSQLException(e.getFriendlyMessage(), e.getCause());
        }
    }


    @Override
    public ResponseEntity<ColumnDto> get(Long id) {
        return null;
    }
}
