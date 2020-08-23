package com.seriesrecap.SeriesRecap.Services.impl;


import com.seriesrecap.SeriesRecap.Entites.Series;
import com.seriesrecap.SeriesRecap.Entites.User;
import com.seriesrecap.SeriesRecap.Repositories.SeriesRepository;
import com.seriesrecap.SeriesRecap.Services.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeriesServiceImpl implements SeriesService {

    private final SeriesRepository seriesRepository;

    @Override
    public List<Series> getAllSeries(User user) {
        List<Series> series =  seriesRepository.findByUser(user);
        return series;
    }

    @Override
    public Series getSeriesById(int id) {

        Optional<Series> series = seriesRepository.findById(id);

        return series.orElse(null);
    }


    @Override
    public Series saveSeries(Series series) {
        return seriesRepository.save(series);
    }
}
