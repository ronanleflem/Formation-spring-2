package com.formation.partie2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TaskDTO {

    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private Boolean completed;

    private Long idUser;


}
