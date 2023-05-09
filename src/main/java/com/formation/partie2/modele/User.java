package com.formation.partie2.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
public class User implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private List<Task> lstTask;


}