package uz.elmurodov.exception;


import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.enums.HttpStatus;

@Getter
@Setter
public class CustomerSQLException extends RuntimeException {

    private String friendlyMessage;
    private HttpStatus status;

    public CustomerSQLException(String message, Throwable cause) {
        super(message, cause);
        initMessage();
    }

    private void initMessage() {
        this.friendlyMessage = null;
        String message = super.getMessage();
        String systemMessage = message.trim();
        try {
            friendlyMessage = systemMessage.substring(systemMessage.lastIndexOf("ERROR: ") + 7, systemMessage.indexOf("Where")).trim();
            if (friendlyMessage.isEmpty()) {
                friendlyMessage = systemMessage.substring(systemMessage.lastIndexOf("detail: ") + 8, systemMessage.indexOf("hint: ")).trim();
            }
            if (friendlyMessage.isEmpty()) {
                friendlyMessage = systemMessage.substring(systemMessage.lastIndexOf("hint: ") + 6).trim();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if ("ERROR_CODE_INTERNAL".contains(friendlyMessage))
            status = HttpStatus.HTTP_500;
        else if ("ERROR_CODE_BAD_REQUEST".contains(friendlyMessage))
            status = HttpStatus.HTTP_400;
        else
            status = HttpStatus.UNDEFINED;
    }

}
