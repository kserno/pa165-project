package cz.muni.fi.pa165.rest.controllers;

import cz.muni.fi.pa165.api.dto.area.AreaCreateDTO;
import cz.muni.fi.pa165.api.dto.area.AreaDTO;
import cz.muni.fi.pa165.api.dto.area.AreaListDTO;
import cz.muni.fi.pa165.api.dto.area.AreaUpdateDTO;
import cz.muni.fi.pa165.api.facade.AreaFacade;
import cz.muni.fi.pa165.entity.Area;
import cz.muni.fi.pa165.rest.ApiUris;
import cz.muni.fi.pa165.rest.exceptions.GlobalException;
import cz.muni.fi.pa165.rest.exceptions.ResourceAlreadyExistingException;
import cz.muni.fi.pa165.rest.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(ApiUris.ROOT_URI_AREAS)
public class AreasController {

    final static Logger logger = LoggerFactory.getLogger(AreasController.class);

    @Inject
    private AreaFacade areaFacade;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final List<AreaListDTO> getAreas(){
        logger.debug("rest getAreas");
        return areaFacade.getAllAreas();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final AreaDTO getArea(@PathVariable("id") long id) {

        logger.debug("rest getAreaById({})", id);

        AreaDTO areaDTO = areaFacade.getAreaById(id);
        if (areaDTO == null){
            throw new ResourceNotFoundException();
        }
        return areaDTO;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final AreaDTO createArea(@RequestBody AreaCreateDTO area) throws Exception {

        logger.debug("rest createProduct()");

        try {
            Long id = areaFacade.createArea(area);
            return areaFacade.getAreaById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final AreaDTO updateArea(@PathVariable("id") long id, @RequestBody AreaUpdateDTO area) {
        logger.debug("rest updateArea()");

        try {
            areaFacade.updateArea(area);
            return areaFacade.getAreaById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteArea(@PathVariable("id") long id) {
        logger.debug("rest deleteArea()");

        try {
            areaFacade.deleteArea(id);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{id}/creatures/{creature_id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public final void addCreatureArea(@PathVariable("id") long id, @PathVariable("creature_id") long creatureId) {
        logger.debug("rest addCreatureArea()");

        try {
            areaFacade.addCreatureToArea(id, creatureId);
        } catch (Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

    @RequestMapping(value = "/{id}/creatures/{creature_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void removeCreatureEffectiveness(@PathVariable("id") long id, @PathVariable("creature_id") long creatureId) {
        logger.debug("rest removeAreaFromCreature()");

        try {
            areaFacade.removeCreatureFromArea(id, creatureId);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

}
