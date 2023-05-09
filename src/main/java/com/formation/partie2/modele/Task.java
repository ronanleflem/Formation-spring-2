package com.formation.partie2.modele;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
public class Task implements Serializable {

    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private boolean completed;

    private User user;

}
