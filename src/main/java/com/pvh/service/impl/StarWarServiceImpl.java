package com.pvh.service.impl;

import com.pvh.feign.StarWarFeign;
import com.pvh.model.People;
import com.pvh.model.PeoplesSummary;
import com.pvh.model.Planet;
import com.pvh.model.PlanetSummary;
import com.pvh.service.StarWarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarServiceImpl implements StarWarService {

    private final StarWarFeign starWarFeignClient;

    /**
     * public constructor to auto wire required dependencies
     *
     * @param starWarFeignClient reference of StarWarFeign
     */
   @Autowired
    public StarWarServiceImpl(StarWarFeign starWarFeignClient) {
        this.starWarFeignClient = starWarFeignClient;
    }

    @Override
    public People getPeopleById(String id) {
        return starWarFeignClient.findPeopleById(id);
    }

    @Override
    public PeoplesSummary getPeopleByName(String name,String page) {
        return starWarFeignClient.findPeopleByName(name,page);
    }

    @Override
    public Planet getPlanetById(String id) {
        return starWarFeignClient.findPlanetById(id);
    }

    @Override
    public PlanetSummary getPlanetByName(String name,String page) {
        return starWarFeignClient.findPlanetByName(name,page);
    }
}
