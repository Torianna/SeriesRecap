package com.seriesrecap.SeriesRecap.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")

public class User {

    @Id
    @GeneratedValue
    private int id;


    private String name;

    private String surname;

    private String password;
}