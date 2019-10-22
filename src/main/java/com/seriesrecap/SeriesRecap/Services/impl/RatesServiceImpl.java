package com.seriesrecap.SeriesRecap.Services.impl;

import com.seriesrecap.SeriesRecap.Entites.Rates;
import com.seriesrecap.SeriesRecap.Repositories.RatesRepository;
import com.seriesrecap.SeriesRecap.Services.RatesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class RatesServiceImpl implements RatesService {

    private final RatesRepository ratesRepository; //initialized by using lombok AllArgsConstructor

    @Override
    public Rates getRateById(Long id) {
        Optional<Rates> rates = ratesRepository.findById(id);
        return rates.orElse(null);

    }

    @Override
    public Rates deleteRateById(Long id) {
        Optional<Rates> rates= ratesRepository.findById(id);

        if(rates.isPresent())
        {
            ratesRepository.deleteById(id);
            return rates.get();
        }
        return null;
    }

    @Override
    public Rates editRateById(Long id, Rates rate) {
        Optional<Rates> rates= ratesRepository.findById(id);

        if(rates.isPresent())
        {
            ratesRepository.deleteById(id);
            ratesRepository.save(new Rates(rate.getId(),rate.getSeries(),
                    rate.getPlot(),rate.getEffects(),rate.getBudget(),
                    rate.getEnding());

            return rate;
        }
        return null;
    }

    @Override
    public Rates saveRate(Rates rate) {
        return ratesRepository.save(rate);


    }
}
