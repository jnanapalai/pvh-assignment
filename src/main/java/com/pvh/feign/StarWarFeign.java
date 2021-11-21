package com.pvh.feign;

import com.pvh.configuration.FeignConfiguration;
import com.pvh.exception.FeignErrorDecoder;
import com.pvh.model.People;
import com.pvh.model.PeoplesSummary;
import com.pvh.model.Planet;

import com.pvh.model.PlanetSummary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client to call Swapi api
 *
 */

@FeignClient(name="StarWar",url="https://swapi.dev/api", configuration = FeignConfiguration.class)
public interface StarWarFeign {

    /**
     * Method to find people by id
     *
     * @param id id
     * @return  People
     */
    @GetMapping(value="/people/{id}")
    public People findPeopleById(@PathVariable("id") String id);

    /**
     * Method to find people by name
     *
     * @param name name
     * @param page pageNumber
     * @return PeoplesSummary
     */
    @GetMapping(value="/people/")
    public PeoplesSummary findPeopleByName(@RequestParam("search") String name,@RequestParam("page") String page);

    /**
     * Method to find planet by id
     *
     * @param id id
     * @return  Planet
     */
    @GetMapping(value="/planets/{id}")
    public Planet findPlanetById(@PathVariable("id") String id);

    /**
     * Method to find planet by name
     *
     * @param name name
     * @param page pageNumber
     * @return PlanetSummary
     */
    @GetMapping(value="/planets/")
    public PlanetSummary findPlanetByName(@RequestParam("search") String name,@RequestParam("page") String page);
}
