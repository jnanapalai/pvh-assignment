package com.pvh.controller;


import com.pvh.model.People;
import com.pvh.model.PeoplesSummary;
import com.pvh.model.Planet;
import com.pvh.model.PlanetSummary;
import com.pvh.service.StarWarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * Controller class to serve end point operation
 *
 */
@RestController
@RequestMapping("/api")
@Validated
@Tag(name="starwar",description = "Star War Api")
@CrossOrigin
public class StarWarController {

    private final StarWarService starWarService;

    /**
     * public constructor to auto wire required dependency
     *
     * @param starWarService reference of StarWarService
     */
    @Autowired
    public StarWarController(StarWarService starWarService) {
        this.starWarService = starWarService;
    }

    /**
     * Method to get people details by id
     *
     * @param id people id
     * @return Details of People
     */
    @Operation(summary = "Find People by Id", description = "Search people details by their id", tags = { "starwar" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = People.class))),
            @ApiResponse(responseCode = "404", description = "People not found")
    ,@ApiResponse(responseCode = "400", description = "Invalid Value")})
    @GetMapping(value="/people/{id}",produces = "application/json")
    public ResponseEntity<People> getPeopleById(@PathVariable("id") @Valid @Pattern(regexp = "[0-9]{1,19}+",message="Only Digit greater than zero maximum of length 19 allowed for search people by Id") String id)
    {
        return new ResponseEntity<>(starWarService.getPeopleById(id), HttpStatus.OK);
    }

    /**
     * Method to get all people search by Name
     *
     * @param name name by which people list need to search
     * @param page page number by default 1
     * @return list of people
     */
    @Operation(summary = "Find People by Name", description = "Search people details by their name", tags = { "starwar" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = People.class))),
            @ApiResponse(responseCode = "404", description = "People not found")
            ,@ApiResponse(responseCode = "400", description = "Invalid Value")})
    @GetMapping(value="/people",produces = "application/json")
    public ResponseEntity<PeoplesSummary> getPeopleByName(@RequestParam("name") String name,@RequestParam(name="page",defaultValue = "1")
    @Valid @Pattern(regexp = "[0-9]+",message="Only Digit allowed in page parameter") String page)
    {
      return new ResponseEntity<>(starWarService.getPeopleByName(name,page),HttpStatus.OK);
    }

    /**
     *
     * Method to search planet details by id
     *
     * @param id id by which planet details need to search
     * @return planet details
     */
    @Operation(summary = "Find Planet by Id", description = "Search Planet details by their id", tags = { "starwar" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Planet.class))),
            @ApiResponse(responseCode = "404", description = "Planet not found")
            ,@ApiResponse(responseCode = "400", description = "Invalid Value")})
    @GetMapping(value="/planet/{id}",produces = "application/json")
    public ResponseEntity<Planet> getPlanetById(@PathVariable("id") @Valid @Pattern(regexp = "[0-9]{1,19}+",message="Only Digit greater than zero maximum of length 19 allowed for search planet by Id") String id)
    {
      return new ResponseEntity<>(starWarService.getPlanetById(id),HttpStatus.OK);
    }

    /**
     * Method to search planets by the name and page
     *
     * @param name name
     * @param page page number by default 1
     * @return all planet with matching name and page number
     */
    @Operation(summary = "Find Planet by Name", description = "Search Planet details by their name", tags = { "starwar" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Planet.class))),
            @ApiResponse(responseCode = "404", description = "Planet not found")
            ,@ApiResponse(responseCode = "400", description = "Invalid Value")})
    @GetMapping(value="/planet",produces = "application/json")
    public ResponseEntity<PlanetSummary> getPlanetByName(@RequestParam("name") String name,@RequestParam(name="page",defaultValue = "1")
    @Valid @Pattern(regexp = "[0-9]+",message="Only Digit allowed in page parameter") String page)
    {
      return new ResponseEntity<>(starWarService.getPlanetByName(name,page),HttpStatus.OK);
    }



}
