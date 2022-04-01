package com.enzoApps.beer.controller;

import com.enzoApps.beer.entity.Brewery;
import com.enzoApps.beer.exception.ResourceNotFoundException;
import com.enzoApps.beer.repository.BreweryRepository;
import jdk.jfr.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brewery")
@Slf4j
public class BreweryController {

    @Autowired
    private BreweryRepository breweryRepository;

    @GetMapping
    public List<Brewery> getAllBreweries(){
        return this.breweryRepository.findAll();
    }

    @GetMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Brewery getBreweryById(@PathVariable(value= "id") String breweryId){
        log.info("Getting a brewery by UUID: "+ breweryId);
        return breweryRepository.findById(breweryId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with UUID: " + breweryId)
        );
    }

    @GetMapping(value = {"/{name}"})
    @ResponseStatus(HttpStatus.OK)
    public static Brewery findUserByName(@PathVariable(value = "name") String name) {
        Brewery user = findUserByName(name);
        Brewery opt = user;
        return opt;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Brewery saveNewBrewery(@RequestBody Brewery breweryDto){
        log.info("Creating new brewery: " + breweryDto);
        return this.breweryRepository.save(breweryDto);
    }

    @PatchMapping({"/updateBrewery/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Brewery updateBrewery(@PathVariable("id")String breweryId, @RequestBody Brewery breweryDto){
        log.info("Updating a brewery by id: " + breweryId + " : " + breweryDto);
    Brewery existingBrewery = this.breweryRepository.findById(breweryId)
            .orElseThrow(()->new ResourceNotFoundException("Brewery for this UUID: " + breweryId + " was not found.")
            );
    existingBrewery.setBrewery_type(breweryDto.getBrewery_type());
    existingBrewery.setAddress_2(breweryDto.getAddress_2());
    existingBrewery.setAddress_3(breweryDto.getAddress_3());
    existingBrewery.setCity(breweryDto.getCity());
    existingBrewery.setCounty_province(breweryDto.getCounty_province());
    existingBrewery.setCountry(breweryDto.getCountry());
    existingBrewery.setId(breweryDto.getId());
    existingBrewery.setLongitude(breweryDto.getLongitude());
    existingBrewery.setName(breweryDto.getName());
    existingBrewery.setPhone(breweryDto.getPhone());
    existingBrewery.setLatitude(breweryDto.getLatitude());
    existingBrewery.setPostal_code(breweryDto.getPostal_code());
    existingBrewery.setState(breweryDto.getState());
    existingBrewery.setStreet(breweryDto.getStreet());
    existingBrewery.setWebsite_url(breweryDto.getWebsite_url());
    return this.breweryRepository.save(existingBrewery);
    }

    @DeleteMapping({"/deleteBrewery/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Brewery> deleteBrewery(@PathVariable("id")String breweryId){
        log.info("Deleting a brewery by UUID: ");
Brewery existingBrewery = this.breweryRepository.findById(breweryId)
        .orElseThrow(() -> new ResourceNotFoundException("Brewery for this UUID: " + breweryId + " was not found."));
    this.breweryRepository.delete(existingBrewery);
return ResponseEntity.ok().build();
    }

}
