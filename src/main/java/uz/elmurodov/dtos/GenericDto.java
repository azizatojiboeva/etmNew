package uz.elmurodov.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericDto implements GenericBaseDto {
    private Long id;
}
