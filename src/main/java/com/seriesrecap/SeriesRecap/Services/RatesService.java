package com.seriesrecap.SeriesRecap.Services;


import com.seriesrecap.SeriesRecap.Entites.Rates;

public interface RatesService {

    Rates getRateById(Long id);

    Rates deleteRateById(Long id);

    Rates editRateById(Long id, Rates rate);

    Rates saveRate(Rates rate);
}
