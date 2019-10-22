package com.seriesrecap.SeriesRecap.Services;

import com.seriesrecap.SeriesRecap.Entites.Types;

public interface TypesService {

    Types getTypeById(Long id);

    Types deleteTypeById(Long id);

    Types editTypeById(Long id, Types type);

    Types saveType (Types type);

}
