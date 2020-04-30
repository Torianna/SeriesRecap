package com.seriesrecap.SeriesRecap.Services.impl;


import com.seriesrecap.SeriesRecap.Entites.Series;
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
    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    @Override
    public Series getSeriesById(int id) {

        Optional<Series> series = seriesRepository.findById(id);

        return series.orElse(null);
    }

    @Override
    public Series deleteSeriesById(int id) {

        Optional<Series> series = seriesRepository.findById(id);

        if (series.isPresent()) {
            seriesRepository.deleteById(id);

            return series.get();
        }
        return null;
    }

    @Override
    public Series editSeriesById(int id, Series series) {
        Optional<Series> serie = seriesRepository.findById(id);
        if (serie.isPresent()) {
            seriesRepository.deleteById(id);
            seriesRepository.save(new Series(series.getId(), series.getName(),
                    series.getPhoto(), series.getYear(), series.getDescription(), series.getTotalScore(), series.getRates()));

            return series;
        }
        return null;
    }

    @Override
    public Series saveSeries(Series series) {
        return seriesRepository.save(series);
    }
}
