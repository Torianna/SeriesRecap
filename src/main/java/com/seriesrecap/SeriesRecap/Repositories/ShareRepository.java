package com.seriesrecap.SeriesRecap.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seriesrecap.SeriesRecap.Entites.ShareList;

public interface ShareRepository  extends JpaRepository<ShareList, String> {
}
