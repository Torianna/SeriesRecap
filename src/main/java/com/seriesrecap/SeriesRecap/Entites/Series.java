package com.seriesrecap.SeriesRecap.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Series {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String year;
    private String photo; //as an url
    private String description;


    @ManyToOne
    private Rates rates;





}
