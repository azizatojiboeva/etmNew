package uz.elmurodov;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.ui.Menu;
import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.Input;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {


        Menu.getMainMenu();
        String choice = Input.getStr("Your choice");

        switch (choice.toUpperCase()) {
            case "LOGIN" -> {
                AuthUserService service = UNIContainer.getBean(AuthUserService.class);
                Scanner scanner = new Scanner(System.in);
                System.out.print("Username : ");
                String username = scanner.nextLine();
                System.out.print("Password : ");
                String password = scanner.nextLine();
                ResponseEntity<Data<?>> response = service.login(username, password);
                if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
                    System.out.println(response.getBody().getData());
                } else {
                    System.out.println(BaseUtils.gson.toJson(SecurityHolder.session));
                }
            }
        }

    }


    public void hi() {
        System.out.println("Heloo");
    }

}
