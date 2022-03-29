package uz.elmurodov.ui.task;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.task.CommentDto;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.task.TaskService;
import uz.elmurodov.ui.BaseAbstractUI;

import static uz.jl.utils.Input.getNum;
import static uz.jl.utils.Input.getStr;

/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday  January 23 : 37
 */
public class TaskUI extends BaseAbstractUI {

    TaskService taskService = UNIContainer.getBean(TaskService.class);


    public void create() {
        try {
            SecurityHolder.hasPermission("TASK_CREATE");
            String name = getStr("Enter task name: ");
            String description = getStr("Enter task description: ");
            int proColId = getNum("Enter column id: ");
            String deadline = getStr("Enter deadline: (When you are expecting to complete? )");
            int order = getNum("Specify order: ");
            int priority = getNum("How important this task? PLease, check out the priority -> (4-5-6) ");
            int level = getNum("How difficult the task is? Please, assess the level -> (1-2-3) ");
            TaskCreateDto dto = new TaskCreateDto(name, description, proColId,
                    deadline, order, level, priority);
            ResponseEntity<Data<?>> response = taskService.create(dto);
            show(response);
        } catch (Exception e) {
            show(e);
        }
    }

    public void update() {
        try {
            SecurityHolder.hasPermission("TASK_UPDATE");
            int taskId = getNum("Enter task id to update: ");
            TaskUpdateDto dto = new TaskUpdateDto();
            dto.setId((long) taskId);

            int columnId = getNum("Enter columnId: ");
            dto.setProject_column_id(columnId);

            String choice = getStr("Want to update name ? (yes/no) ");
            String uname = null;
            if (choice.startsWith("y")) {
                uname = getStr("Name: ");
            }
            dto.setName(uname);
            String description = null;
            String choice1 = getStr("Want to update description ? (yes/no) ");
            if (choice1.startsWith("y")) {
                description = getStr("Description: ");
            }
            dto.setDescription(description);
            String choice3 = getStr("Want to update priority ? (yes/no) ");
            if (choice3.startsWith("y")) {
                int priority = getNum("Enter priority degree (4-5-6): ");
                dto.setPriority(priority);
            }
            String choice4 = getStr("Want to update level ? (yes/no) ");
            if (choice4.startsWith("y")) {
                int level = getNum("Enter level (1-2-3): ");
                dto.setLevel(level);
            }
            String choice5 = getStr("Want to update order ? (yes/no) ");
            if (choice5.startsWith("y")) {
                int level = getNum("Enter new order: ");
                dto.setOrder(level);
            }
            ResponseEntity<Data<?>> response = taskService.update(dto);
            show(response);
        } catch (Exception e) {
            show(e);
        }
    }


    public void delete() {
        try {
            SecurityHolder.hasPermission("TASK_DELETE");
            int taskId = getNum("Enter task id to remove it: ");
            ResponseEntity<Data<Boolean>> response = taskService.delete(taskId);
            show(response);
        } catch (CustomerSQLException e) {
            show(e);
        }
    }


    public void leaveComment() {
        try {
            int id = getNum("Enter task id to leave comment: ");
            String message = getStr("Your comment...");
            CommentDto dto = new CommentDto(message, id);
            ResponseEntity<Data<Long>> response = taskService.leaveComment(dto);
            show(response);
        } catch (CustomerSQLException e) {
            show(e);
        }
    }

}
