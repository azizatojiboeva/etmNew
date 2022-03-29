package uz.elmurodov.ui.organization;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.Info;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.ui.BaseAbstractUI;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.List;

import static uz.jl.utils.Input.getNum;
import static uz.jl.utils.Input.getStr;

/**
 * @author Aziza Tojiboyeva
 * @date 17 Monday  January 13 : 45
 */

public class OrganizationUI extends BaseAbstractUI {
    OrganizationService orgService = UNIContainer.getBean(OrganizationService.class);


    public void createOrg() {
        try {
            SecurityHolder.hasPermission("CREATE_ORGANIZATION");
            String name = getStr("Name: ");
            String logo = getStr("Logo: ");
            String website = getStr("Website: ");
            String regNum = getStr("Register Number: ");
            String email = getStr("Email: ");
            OrganizationCreateDto dto = new OrganizationCreateDto(name, logo, email, website, regNum);
            ResponseEntity<Data<?>> response = orgService.create(dto);
            show(response);
        } catch (Exception e) {
            show(e);
        }
    }

    public void updateOrg() {
        try {
            SecurityHolder.hasPermission("UPDATE_ORGANIZATION");
            OrganizationUpdateDto dto = new OrganizationUpdateDto();
            String name = getStr("Enter organization  name to update: ");
            try {
                Long id = orgService.getId(name);
                dto.setId(id);
            } catch (CustomerSQLException e) {
                e.printStackTrace();
            }
            String email = null;
            String choice1 = getStr("Want to update email ? (yes/no) ");
            if (choice1.startsWith("y")) {
                email = getStr("Email: ");
            }
            String logo = null;
            String choice2 = getStr("Want to update logo ? (yes/no) ");
            if (choice2.startsWith("y")) {
                logo = getStr("logo: ");
            }
            String website = null;
            String choice3 = getStr("Want to update website ? (yes/no) ");
            if (choice3.startsWith("y")) {
                website = getStr("website: ");
            }
//            String choice4 = getStr("Want to update location ? (yes/no) ");
//            if (choice4.startsWith("y")) {
//                double x = getNum("Alright, then enter latitude : ");
//                double y = getNum("Alright, then enter longitude : ");
//                uz.elmurodov.utils.Point location = new Point(x,y);
//                dto.setLocation(location);
//            }
            dto.setLogo(logo);
            dto.setEmail(email);
            dto.setWebsite(website);
            dto.setLocation(null);
            ResponseEntity<Data<?>> response = orgService.update(dto);
            show(response);
        } catch (Exception e) {
            show(e);
        }
    }


    public void blockOrg() {
        try {
            SecurityHolder.hasPermission("BLOCK_ORGANIZATION");
            String name = getStr("Enter organization  name to block: ");
            try {
                Long id = orgService.getId(name);
                ResponseEntity<Data<Object>> response = orgService.block(id);
                show(response);
            } catch (CustomerSQLException e) {
                show(new ResponseEntity(e.getFriendlyMessage(), e.getStatus()));
            }
        } catch (Exception e) {
            show(e);
        }
    }

    public void unBlockOrg() {
        try {
            SecurityHolder.hasPermission("UNBLOCK_ORGANIZATION");
            String name = getStr("Enter organization  name to unblock: ");
            try {
                Long id = orgService.getId(name);
                ResponseEntity<Data<Object>> response = orgService.unBlock(id);
                show(response);
            } catch (CustomerSQLException e) {
                show(new ResponseEntity(e.getFriendlyMessage(), e.getStatus()));
            }
        } catch (Exception e) {
            show(e);
        }

    }

    public void deleteOrg() {
        try {
            SecurityHolder.hasPermission("DELETE_ORGANIZATION");
            int id = getNum("Enter organizationId to delete: ");
            ResponseEntity<Data<Boolean>> response = orgService.delete((long) id);
            show(response);
        } catch (Exception e) {
            show(e);
        }
    }

    public void showOrg() {
        try {
            SecurityHolder.hasPermission("SEE_ORGANIZATIONS");
            ResponseEntity<Data<List<Info>>> response = orgService.showList();
            Data<List<Info>> body = response.getBody();
            List<Info> data = body.getData();
            Long total = body.getTotal();

            int count = 1;
            Print.println(Color.RED, "========ORGANIZATIONS========");
            for (Info info : data) {
                Print.println(Color.CYAN, (count++) + " -> ORGANIZATION");
                Print.println(Color.YELLOW, "Id: " + info.getId());
                Print.println(Color.YELLOW, "Name: " + info.getName());
                Print.println(Color.YELLOW, "Paid for: " + info.getPaidFor());
                Print.println(Color.YELLOW, "Register number: " + info.getRegisterNumber());
                Print.println(Color.YELLOW, "Logo: " + info.getLogo());
                Print.println(Color.YELLOW, "Website: " + info.getWebsite());
                Print.println(Color.YELLOW, "Created_at " + info.getCreatedAt());
                Print.println(Color.YELLOW, "Created_by " + info.getCreatedBy());
                Print.println(Color.YELLOW, "Status: " + info.getStatus());
            }

        } catch (Exception e) {
            show(e);
        }
    }

    public void changeStatus() {
        try {
            SecurityHolder.hasRole("SUPER_ADMIN");
            int newStatus = getNum("Enter new status: ");
            int orgId = getNum("Enter organization id: ");
            ResponseEntity<Data<Boolean>> response = orgService.changeStatus(newStatus, orgId);
            show(response);
        } catch (Exception e) {
            show(e);
        }
    }


}
