package com.enzoApps.beer.service.impl;

import com.enzoApps.beer.entity.Brewery;
import com.enzoApps.beer.model.BreweryResponse;
import com.enzoApps.beer.repository.BreweryRepository;
import com.enzoApps.beer.service.BreweryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryImplementation implements BreweryService {

    public BreweryImplementation(BreweryRepository breweryRepository,
                                 ModelMapper modelMapper)
    {
        this.breweryRepository = breweryRepository;
        this.modelMapper = modelMapper;
    }

    private BreweryRepository breweryRepository;
    private ModelMapper modelMapper;


    @Override
    public BreweryResponse getBreweryById(Long breweryId) {
        return null;
    }

    @Override
    public Brewery setNewBreweryDto(Brewery doctorDto) {
        return null;
    }

    @Override
    public Brewery updateBrewery(Long doctorDtoId, Brewery doctorDto) {
        return null;
    }

    @Override
    public void deleteBrewery(Long doctorDtoId) {

    }
    @Override
    public List<Brewery> getBreweries() {
        return null;
    }
}
