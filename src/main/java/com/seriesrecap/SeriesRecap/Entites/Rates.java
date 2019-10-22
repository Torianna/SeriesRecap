package com.seriesrecap.SeriesRecap.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Rates {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private Series series;

    private int plot;
    private int effects;
    private int ending;
    private int budget;



}
