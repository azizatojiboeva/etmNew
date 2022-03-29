package uz.elmurodov.dtos.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Aziza Tojiboyeva
 * @date 20 Thursday  January 23 : 05
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String message;
    private int taskId;
}
