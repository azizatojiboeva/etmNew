package uz.elmurodov.ui.project;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.ResponseItem;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.project.ProjectService;
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
public class ProjectUI extends BaseAbstractUI {
    ProjectService projectService = UNIContainer.getBean(ProjectService.class);


    public void createProject() {
        try {
            if (SecurityHolder.hasPermission("CREATE_PROJECT")) {
                String name = getStr("Name: ");
                String description = getStr("Description: ");
                String tz = getStr("TZ : ");
                String background = getStr("Background: ");
                int orgId = getNum("Organization id: ");
                ProjectCreateDto dto = ProjectCreateDto.builder()
                        .name(name)
                        .description(description)
                        .background(background)
                        .tz(tz)
                        .organization_id((long) orgId)
                        .build();
                ResponseEntity<Data<?>> response = projectService.create(dto);
                show(response);
            } else {
                ResponseEntity<Data<String>> response = new ResponseEntity<>(new Data<>("Permission_denied"));
                show(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteProject() {
        try{
            SecurityHolder.hasPermission("DELETE_PROJECT");
            int id=getNum("Enter project id: ");
            ResponseEntity<Data<?>> response=projectService.delete(id);
            show(response);
        }catch (Exception e){
            show(e);
        }
    }


    public void updateProject() {
        try {
            SecurityHolder.hasPermission("UPDATE_PROJECT");
            projectList();
            ProjectUpdateDto dto = new ProjectUpdateDto();
            int id = getNum("Enter project id: ");
            dto.setId((long) id);
            int orgId = getNum("Enter organization id: ");
            dto.setOrganization_id((long) orgId);
            String choice = getStr("Want to update name ? (yes/no) ");
            String uname = null;
            if (choice.startsWith("y")) {
                uname = getStr("Name: ");
            }
            String description = null;
            String choice1 = getStr("Want to update description ? (yes/no) ");
            if (choice1.startsWith("y")) {
                description = getStr("Description: ");
            }
            String tz = null;
            String choice2 = getStr("Want to update tz ? (yes/no) ");
            if (choice2.startsWith("y")) {
                tz = getStr("tz: ");
            }
            String background = null;
            String choice3 = getStr("Want to update background ? (yes/no) ");
            if (choice3.startsWith("y")) {
                background = getStr("background: ");
            }
            dto.setName(uname);
            dto.setDescription(description);
            dto.setBackground(background);
            dto.setTz(tz);
            ResponseEntity<Data<?>> response = projectService.update(dto);
            show(response);
        } catch (Exception e) {
            show(e);
        }
    }


    public void addMember() {
        try{
            SecurityHolder.hasPermission("ADD_PROJECT_MEMBER");
            int proId=getNum("Enter project id:");
            int userId=getNum("Enter user id: ");
            ResponseEntity<Data<?>>response=projectService.addMember(proId,userId);
            show(response);
        }catch (Exception e){
            show(e);
        }
    }


    public void leaveProject() {
        try{
            SecurityHolder.hasPermission("LEAVE_PROJECT");
            int proId=getNum("Enter project id:");
            int userId=getNum("Enter user id: ");
            ResponseEntity<Data<?>>response=projectService.leaveProject(proId,userId);
            show(response);
        }catch (Exception e){
            show(e);
        }
    }


    public void projectList() {
        try{
            SecurityHolder.hasPermission("PROJECT_LIST");
            ResponseEntity<Data<List<ResponseItem>>>response=projectService.show();
            int count=1;
            Print.println(Color.RED,"========PROJECTS========");
            for (int i = 0; i < response.getBody().getData().size(); i++) {
                Print.println(Color.CYAN,(count++)+" -> PROJECT");
                Print.println(Color.YELLOW,"Id: "+response.getBody().getData().get(i).getId());
                Print.println(Color.YELLOW,"Name: "+response.getBody().getData().get(i).getName());
                Print.println(Color.YELLOW,"TZ: "+response.getBody().getData().get(i).getTz());
                Print.println(Color.YELLOW,"Background: "+response.getBody().getData().get(i).getBackground());
                Print.println(Color.YELLOW,"OrganizationId: "+response.getBody().getData().get(i).getOrganizationId());
                Print.println(Color.YELLOW,"Description: "+response.getBody().getData().get(i).getDescription());
                Print.println(Color.YELLOW,"Status: "+response.getBody().getData().get(i).getStatus());
            }
        }catch (Exception e){
            show(e);
        }
    }

    public void projectBlock() {
        try{
            SecurityHolder.hasPermission("PROJECT_BLOCK");
            int id=getNum("Enter project id to block: ");
            ResponseEntity<Data<?>>response=projectService.block(id);
            show(response);
        }catch (Exception e){
            show(e);
        }
    }

    public void projectUnBlock() {
        try{
            SecurityHolder.hasPermission("PROJECT_UNBLOCK");
            int id=getNum("Enter project id to unBlock: ");
            ResponseEntity<Data<?>>response=projectService.unBlock(id);
            show(response);
        }catch (Exception e){
            show(e);
        }
    }



}
