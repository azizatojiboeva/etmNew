package uz.elmurodov.security;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShowUserItem {

    private InfoItem info;

    private String code;
}