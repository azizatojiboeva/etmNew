package uz.elmurodov.ui.column;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnUpdateDto;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.column.ColumnService;
import uz.elmurodov.ui.BaseAbstractUI;

import static uz.jl.utils.Input.getNum;
import static uz.jl.utils.Input.getStr;

/**
 * @author Aziza Tojiboyeva
 * @date 20 Thursday  January 02 : 02
 */

public class ColumnUI extends BaseAbstractUI {
    ColumnService columnService = UNIContainer.getBean(ColumnService.class);

    public void createColumn() {
        try {
            SecurityHolder.hasPermission("CREATE_COLUMN");
            String name = getStr("Enter column name: ");
            String emoji = getStr("Enter column emoji: ");
            int project_id = getNum("Enter project id: ");
            int order = getNum("Enter column order: ");
            ColumnCreateDto dto = new ColumnCreateDto(name, (long) project_id, order, emoji);
            ResponseEntity<Data<?>> response = columnService.create(dto);
            show(response);
        } catch (Exception e) {
            show(e);
        }
    }

    public void updateColumn() {
        try {
            SecurityHolder.hasPermission("UPDATE_COLUMN");
            int id = getNum("Enter column id: ");
            String name = getStr("Name: ");
            String emoji = getStr("Emoji: ");
            int order = getNum("New order: ");
            ColumnUpdateDto dto = new ColumnUpdateDto();
            dto.setName(name);
            dto.setColumn_id(id);
            dto.setEmoji(emoji);
            dto.setOrder(order);
            ResponseEntity<Data<?>> response = columnService.update(dto);
            show(response);
        } catch (Exception e) {
            show(e);
        }
    }


    public void deleteColumn() {
        try{
            SecurityHolder.hasPermission("DELETE_COLUMN");
            int id=getNum("Enter column id: ");
           ResponseEntity<Data<?>>response=columnService.delete(id);
           show(response);
        }catch (Exception e){
            show(e);
        }
    }

}
