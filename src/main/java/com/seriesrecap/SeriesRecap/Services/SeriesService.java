package com.seriesrecap.SeriesRecap.Services;

import com.seriesrecap.SeriesRecap.Entites.Series;
import com.seriesrecap.SeriesRecap.Entites.User;

import java.util.List;

public interface SeriesService {

    List<Series> getAllSeries(User user);

    Series getSeriesById(int id);

    Series saveSeries(Series series);
    
    void deleteSeriesById(int id);

}
