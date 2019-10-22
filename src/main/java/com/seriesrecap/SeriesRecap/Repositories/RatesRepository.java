package com.seriesrecap.SeriesRecap.Repositories;

import com.seriesrecap.SeriesRecap.Entites.Rates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatesRepository extends JpaRepository <Rates, Long> {
}
