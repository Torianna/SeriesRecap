package com.seriesrecap.SeriesRecap.Controllers;


import com.seriesrecap.SeriesRecap.Entites.Series;
import com.seriesrecap.SeriesRecap.Entites.User;
import com.seriesrecap.SeriesRecap.Services.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seriesRecap/series")
@CrossOrigin
public class SeriesController {

    final private SeriesService seriesService;

    @GetMapping("")
    public ResponseEntity<List<Series>> getAllSeries (User user){

        List<Series> seriesList=seriesService.getAllSeries(user);

        return seriesList.isEmpty() ? new ResponseEntity<>(seriesList, HttpStatus.NO_CONTENT):
           new ResponseEntity<>(seriesList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Series> getSeriesById (@PathVariable int id){

        Series series=seriesService.getSeriesById(id);

        return series != null ? new ResponseEntity<>(series, HttpStatus.OK):
           new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("")
    public ResponseEntity<Series> saveSeries(@RequestBody Series series)
    {
        Series savedSeries= seriesService.saveSeries(series);

        return savedSeries != null ? new ResponseEntity<>(savedSeries, HttpStatus.OK):
           new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
