package com.seriesrecap.SeriesRecap.Repositories;

import com.seriesrecap.SeriesRecap.Entites.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesRepository extends JpaRepository <Types, Long> {
}
