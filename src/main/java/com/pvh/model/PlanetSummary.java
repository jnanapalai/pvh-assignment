package com.pvh.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
/**
 * Model class
 */
@Getter
@Setter
public class PlanetSummary {
    private int count;
    private String next;
    private String previous;
    private List<Planet> results;

}
