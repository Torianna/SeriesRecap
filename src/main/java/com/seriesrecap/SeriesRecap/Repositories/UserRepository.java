package com.seriesrecap.SeriesRecap.Repositories;

import com.seriesrecap.SeriesRecap.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
