package com.seriesrecap.SeriesRecap.Services.impl;


import com.seriesrecap.SeriesRecap.Entites.Series;
import com.seriesrecap.SeriesRecap.Entites.ShareList;
import com.seriesrecap.SeriesRecap.Entites.User;
import com.seriesrecap.SeriesRecap.Repositories.SeriesRepository;
import com.seriesrecap.SeriesRecap.Repositories.ShareRepository;
import com.seriesrecap.SeriesRecap.Services.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;


@Service
@AllArgsConstructor
public class SeriesServiceImpl implements SeriesService {

	@Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private ShareRepository shareRepository;
	
    @Override
    public List<Series> getAllSeriesByUser(User user) {
        List<Series> series =  seriesRepository.findByUser(user);
        return series;
    }

    @Override
    public ShareList getListById(String seriesId) {
        Optional<ShareList> series =  shareRepository.findById(seriesId);
        return series.orElse(null);
    }

    @Override
    public List<Series> getAllSeries() {
        List<Series> series =  seriesRepository.findAll();
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


    @Override
    public ShareList saveList(ShareList shareList) {
        return shareRepository.save(shareList);
    }

    @Override
    public void deleteSeriesById(int id) {
		seriesRepository.deleteById(id);
	}
}
