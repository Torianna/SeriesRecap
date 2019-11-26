package com.seriesrecap.SeriesRecap.Repositories;

import com.seriesrecap.SeriesRecap.Entites.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository <Series, Integer> {
}
