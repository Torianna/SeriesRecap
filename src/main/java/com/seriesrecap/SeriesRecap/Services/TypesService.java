package com.seriesrecap.SeriesRecap.Services;

import com.seriesrecap.SeriesRecap.Entites.Types;

public interface TypesService {

    Types getTypeById(int id);

    Types deleteTypeById(int id);

    Types editTypeById(int id, Types type);

    Types saveType (Types type);

}
