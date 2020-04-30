package com.seriesrecap.SeriesRecap.Services;

import com.seriesrecap.SeriesRecap.Entites.Series;

import java.util.List;

public interface SeriesService {

    List<Series> getAllSeries();

    Series getSeriesById(int id);

    Series deleteSeriesById(int id);

    Series editSeriesById(int id, Series series);

    Series saveSeries(Series series);

}
