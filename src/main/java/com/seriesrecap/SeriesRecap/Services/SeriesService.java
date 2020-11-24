package com.seriesrecap.SeriesRecap.Services;

import com.seriesrecap.SeriesRecap.Entites.Series;
import com.seriesrecap.SeriesRecap.Entites.ShareList;
import com.seriesrecap.SeriesRecap.Entites.User;

import java.util.List;

public interface SeriesService {

    List<Series> getAllSeries();

    List<Series> getAllSeriesByUser(User user);

    ShareList getListById(String seriesId);

    Series getSeriesById(int id);

    Series saveSeries(Series series);

    ShareList saveList(ShareList shareList);
    
    void deleteSeriesById(int id);

}
