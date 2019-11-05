package com.seriesrecap.SeriesRecap.Controllers;


import com.seriesrecap.SeriesRecap.Entites.Rates;
import com.seriesrecap.SeriesRecap.Services.RatesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/seriesRecap/rates")
@CrossOrigin
@AllArgsConstructor

public class RatesController {

    private final RatesService ratesService;

    @GetMapping("/{id}")
    public ResponseEntity<Rates> getRatesById (@PathVariable Long id){
        Rates rates=ratesService.getRateById(id);

        return rates != null ? new ResponseEntity<>(rates, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    };

    @PutMapping("/{id}")
    public ResponseEntity<Rates> editRateById(@PathVariable Long id,
                                                            @RequestBody Rates rates) {

        Rates editRate = ratesService.editRateById(id,rates);

        return editRate != null ? new ResponseEntity<>(editRate, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Rates> deleteRateById(@PathVariable Long id) {
        Rates removedRate = ratesService.deleteRateById(id);


        return removedRate != null ? new ResponseEntity<>(removedRate, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("")
    public ResponseEntity<Rates> addRate(@RequestBody Rates rates) {
        ratesService.saveRate(rates);
        Rates rate = new Rates(rates.getId(),rates.getSeries(),rates.getEffects(),rates.getBudget(),rates.getEnding(),rates.getPlot());

        return new ResponseEntity<>(rate, HttpStatus.OK);
    }
}
