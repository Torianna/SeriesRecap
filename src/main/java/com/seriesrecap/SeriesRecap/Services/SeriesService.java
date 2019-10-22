package com.seriesrecap.SeriesRecap.Services;

import com.seriesrecap.SeriesRecap.Entites.Series;

import java.util.List;

public interface SeriesService {

    List<Series> getAllSeries();

    Series getSeriesById(Long id);

    Series deleteSeriesById(Long id);

    Series editSeriesById(Long id, Series series);

    Series saveSeries(Series series);

}
