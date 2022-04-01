package com.enzoApps.beer.controller;

import com.enzoApps.beer.entity.Brewery;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class BreweryApiRestClient {
    private static final String GET_ALL_BREWERYS_API = "https://api.openbrewerydb.org/breweries";
    private static final String GET_BREWERY_BY_ID_API = "https://api.openbrewerydb.org/breweries/{id}";
    private static final String GET_BREWERY_BY_NAME_API = "https://api.openbrewerydb.org/breweries/{name}";
    private static final String CREATE_BREWERY_API = "https://api.openbrewerydb.org/breweries";
    private static final String UPDATE_BREWERY_API = "https://api.openbrewerydb.org/breweries/{id}";
    private static final String DELETE_BREWERY_API = "https://api.openbrewerydb.org/breweries/{id}";

    static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {

    callGetAllBrewerysApi();
    callGetBreweryById("barrel-brothers-brewing-company-windsor");
    }

private static void callGetAllBrewerysApi(){
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    HttpEntity<String> entity = new HttpEntity<>("parameters",headers);

    ResponseEntity<String> result = restTemplate.exchange(GET_ALL_BREWERYS_API, HttpMethod.GET, entity, String.class);
    System.out.println(result);
}
private static void callGetBreweryById(String breweryId){

    Map<String, String> parameter = new HashMap<>();
    parameter.put("id",breweryId);
    Brewery brewery = restTemplate.getForObject(GET_BREWERY_BY_ID_API, Brewery.class, parameter);
    System.out.println(
            brewery.getId() + System.lineSeparator() +
                    brewery.getName()+ System.lineSeparator() +
                    brewery.getCountry() + System.lineSeparator() +
                    brewery.getBrewery_type()
    );
}
}
