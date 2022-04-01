package com.enzoApps.beer.service;

import com.enzoApps.beer.entity.Brewery;
import com.enzoApps.beer.model.BreweryResponse;

import java.util.List;

public interface BreweryService{
    BreweryResponse getBreweryById(Long breweryId);

    Brewery setNewBreweryDto(Brewery doctorDto);

    Brewery updateBrewery(Long doctorDtoId, Brewery doctorDto);

    void deleteBrewery(Long doctorDtoId);

    List<Brewery> getBreweries();
}
