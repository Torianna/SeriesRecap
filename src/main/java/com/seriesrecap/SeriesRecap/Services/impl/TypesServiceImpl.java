package com.seriesrecap.SeriesRecap.Services.impl;

import com.seriesrecap.SeriesRecap.Entites.Types;
import com.seriesrecap.SeriesRecap.Repositories.TypesRepository;
import com.seriesrecap.SeriesRecap.Services.TypesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class TypesServiceImpl implements TypesService {

    private final TypesRepository typesRepository;

    @Override
    public Types getTypeById(Long id) {
        Optional<Types> types= typesRepository.findById(id);
        return types.orElse(null) ;
    }

    @Override
    public Types deleteTypeById(Long id) {
        Optional<Types> types= typesRepository.findById(id);

        if(types.isPresent())
        {
            typesRepository.deleteById(id);

            return types.get();
        }
        return null;
    }

    @Override
    public Types editTypeById(Long id, Types type) {
        Optional<Types> types= typesRepository.findById(id);
        if(types.isPresent())
        {
            typesRepository.deleteById(id);
            typesRepository.save(new Types(type.getId(),type.getSeriesName(),type.getType()));
            return type;
        }
        return null;
    }

    @Override
    public Types saveType(Types type) {
        return typesRepository.save(type);
    }
}
