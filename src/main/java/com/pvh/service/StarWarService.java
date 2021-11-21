package com.pvh.service;

import com.pvh.model.People;
import com.pvh.model.PeoplesSummary;
import com.pvh.model.Planet;
import com.pvh.model.PlanetSummary;

import java.util.List;

/**
 * Service class to get people and planet information
 */
public interface StarWarService {

    public People getPeopleById(String id);
    public PeoplesSummary getPeopleByName(String name,String page);
    public Planet getPlanetById(String id);
    public PlanetSummary getPlanetByName(String name,String page);

}
