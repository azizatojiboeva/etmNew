package uz.elmurodov.repository.column;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;

/**
 * @author Aziza Tojiboyeva
 * @date 20 Thursday  January 01 : 52
 */
public class ColumnRepository extends BaseRepository {
    DatabaseProperties properties= UNIContainer.getBean(DatabaseProperties.class);

    public Long create(ColumnCreateDto dto, int sessionId){
        prepareArguments(BaseUtils.gson.toJson(dto),sessionId);
        return (Long) callProcedure(properties.get("create.column"), Types.BIGINT);
    }

    public Boolean update(ColumnUpdateDto dto, int sessionId){
        prepareArguments(BaseUtils.gson.toJson(dto),sessionId);
        return (Boolean) callProcedure(properties.get("update.column"), Types.BOOLEAN);
    }

    public Boolean delete(int id, int sessionId){
        prepareArguments(sessionId,id);
        return (Boolean) callProcedure(properties.get("delete.column"), Types.BOOLEAN);
    }






}
