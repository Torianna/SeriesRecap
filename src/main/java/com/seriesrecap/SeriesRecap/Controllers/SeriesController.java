package com.seriesrecap.SeriesRecap.Controllers;


import com.seriesrecap.SeriesRecap.Entites.Series;
import com.seriesrecap.SeriesRecap.Entites.ShareList;
import com.seriesrecap.SeriesRecap.Entites.User;
import com.seriesrecap.SeriesRecap.Repositories.ShareRepository;
import com.seriesrecap.SeriesRecap.Services.SeriesService;
import com.seriesrecap.SeriesRecap.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;


import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

@RestController
@AllArgsConstructor
@RequestMapping("/seriesRecap/series")
// /seriesRecap/user/{}/series
@CrossOrigin
public class SeriesController {

	@Autowired
    private SeriesService seriesService;
	
	@Autowired
    private UserService userService;

   public String randomString() {
      byte[] array = new byte[7]; // length is bounded by 7
      new Random().nextBytes(array);
      String generatedString = new String(array, Charset.forName("UTF-8"));

      return generatedString;
   }

    @GetMapping("/userName/{userName}")
    public ResponseEntity<List<Series>> getAllSeries (@PathVariable String userName){
    	User user = userService.findByUserName(userName);
    	System.out.println("user " + user + " userName " + userName);
        List<Series> seriesList=seriesService.getAllSeriesByUser(user);

        return seriesList.isEmpty() ? new ResponseEntity(seriesList, HttpStatus.NO_CONTENT):
                new ResponseEntity(seriesList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Series> getSeriesById (@PathVariable int id){
        Series series=seriesService.getSeriesById(id);
        return series != null ? new ResponseEntity<>(series, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


   @GetMapping("/share/{seriesId}")
   public ResponseEntity<Series> getSharedList (@PathVariable String seriesId){
      ShareList seriesList=seriesService.getListById(seriesId);
      return seriesList != null ? new ResponseEntity(seriesList, HttpStatus.NO_CONTENT):
         new ResponseEntity(seriesList,HttpStatus.OK);
   }

   @PostMapping("/share")
   public ResponseEntity<ShareList> getLinkToShare (@RequestBody String userName){
      User user = userService.findByUserName(userName);
      String id = randomString();
      List<Series> seriesList=seriesService.getAllSeriesByUser(user);
      ShareList shareList = new ShareList(id, seriesList);
      ShareList savedSeries= seriesService.saveList(shareList);
      return savedSeries != null ? new ResponseEntity(savedSeries, HttpStatus.OK):
         new ResponseEntity(HttpStatus.NOT_FOUND);
   }


    @GetMapping("/")
    public ResponseEntity<Series> getSeries (){
        List<Series> series=seriesService.getAllSeries();
        return series != null ? new ResponseEntity(series, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("")
    public ResponseEntity<Series> saveSeries(@RequestBody Series series)
    {
    	System.out.println("1 series " + series + " user " + series.getUser());
    	User user = userService.findByUserName(series.getUser().getUserName());
    	System.out.println("user " + user + " userName " + series.getUser().getUserName());
    	series.setUser(user);
//    	System.out.println("2 series " + series.getId() + " user " + series.getUser().getSeries().size());
    	
        Series savedSeries= seriesService.saveSeries(series);
        System.out.println(savedSeries.getId());
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
