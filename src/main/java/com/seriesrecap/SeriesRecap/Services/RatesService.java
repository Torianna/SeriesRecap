package com.seriesrecap.SeriesRecap.Services;


import com.seriesrecap.SeriesRecap.Entites.Rates;

public interface RatesService {

    Rates getRateById(int id);

    Rates deleteRateById(int id);

    Rates editRateById(int id, Rates rate);

    Rates saveRate(Rates rate);
}
