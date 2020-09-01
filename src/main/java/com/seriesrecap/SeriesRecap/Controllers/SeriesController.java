package com.seriesrecap.SeriesRecap.Controllers;


import com.seriesrecap.SeriesRecap.Entites.Series;
import com.seriesrecap.SeriesRecap.Entites.User;
import com.seriesrecap.SeriesRecap.Services.SeriesService;
import com.seriesrecap.SeriesRecap.Services.UserService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seriesRecap/series")
@CrossOrigin
public class SeriesController {


    @Autowired
    private SeriesService seriesService;

    @Autowired
    private UserService userService;

    @PostMapping("/userName/")
    public ResponseEntity<List<Series>> getAllSeries (@RequestBody String userName
    ){
        User user = userService.findByUserName(userName);
        System.out.println("user " + user + " userName " + userName);
        List<Series> seriesList=seriesService.getAllSeries(user);

        return seriesList.isEmpty() ? new ResponseEntity(seriesList, HttpStatus.NO_CONTENT):
           new ResponseEntity(seriesList,HttpStatus.OK);
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
        User user = userService.findByUserName(series.getUser().getUserName());
        series.setUser(user);
        Series savedSeries= seriesService.saveSeries(series);

        return savedSeries != null ? new ResponseEntity(savedSeries, HttpStatus.OK):
           new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeriesById ( @PathVariable("id") int id){
        System.out.println("deleteSeriesById id " + id);
        seriesService.deleteSeriesById(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
