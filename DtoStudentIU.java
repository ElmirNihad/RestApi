package org.example.springdata.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DtoStudentIU {
    @NotEmpty(message = "Firstname bos birakilamaz!")
    @NotNull(message = "Firstname null olamaz!")
    private String firstname;

    private String lastname;

    private Date birthofdate;
}
