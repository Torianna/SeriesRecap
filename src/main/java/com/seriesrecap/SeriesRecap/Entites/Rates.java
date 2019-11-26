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
@Table(name="rates")

public class Rates {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "series_id")
    private List<Series> series = new ArrayList<>();;

    private int plot;
    private int effects;
    private int ending;
    private int budget;
    private float totalScore;



}
