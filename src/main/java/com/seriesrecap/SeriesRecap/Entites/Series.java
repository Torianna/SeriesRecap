package com.seriesrecap.SeriesRecap.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="series")
public class Series {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String year;
    private String photo; //as an url
    private String description;
    private float totalScore;
    private float score;

    @ManyToOne
    @JoinColumn(name="user_id",nullable=false)
    private User user;
}
