package com.seriesrecap.SeriesRecap.Repositories;

import java.util.List;
import java.util.Optional;

import com.seriesrecap.SeriesRecap.Entites.Series;
import com.seriesrecap.SeriesRecap.Entites.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository <Series, Integer> {
   List<Series> findByUser(User user);
}
