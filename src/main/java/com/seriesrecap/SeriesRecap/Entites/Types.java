package com.seriesrecap.SeriesRecap.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="types")

public class Types {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="series_id")
    private Series seriesName;

    private String type;
}
