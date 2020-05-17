package cz.muni.fi.pa165.rest.controllers;

import cz.muni.fi.pa165.api.dto.creature.*;
import cz.muni.fi.pa165.api.facade.CreatureFacade;
import cz.muni.fi.pa165.rest.ApiUris;
import cz.muni.fi.pa165.rest.exceptions.GlobalException;
import cz.muni.fi.pa165.rest.exceptions.ResourceAlreadyExistingException;
import cz.muni.fi.pa165.rest.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(ApiUris.ROOT_URI_CREATURES)
public class CreaturesController {

    final static Logger logger = LoggerFactory.getLogger(CreaturesController.class);

    @Inject
    private CreatureFacade creatureFacade;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final List<CreatureListDTO> getCreatures(){
        logger.debug("rest getCreatures");
        return creatureFacade.getAllCreatures();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final CreatureDTO getCreature(@PathVariable("id") long id) {

        logger.debug("rest getCreatureById({})", id);

        CreatureDTO creatureDTO = creatureFacade.getCreatureById(id);
        if (creatureDTO == null){
            throw new ResourceNotFoundException();
        }
        return creatureDTO;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final CreatureDTO createCreature(@RequestBody CreatureCreateDTO creature) throws Exception {

        logger.debug("rest createProduct()");

        try {
            Long id = creatureFacade.createCreature(creature);
            return creatureFacade.getCreatureById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final CreatureDTO updateCreature(@PathVariable("id") long id, @RequestBody CreatureUpdateDTO creature) {
        logger.debug("rest updateCreature()");

        try {
            creature.setId(id);
            creatureFacade.updateCreature(creature);
            return creatureFacade.getCreatureById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteCreature(@PathVariable("id") long id) {
        logger.debug("rest deleteCreature()");

        try {
            creatureFacade.deleteCreature(id);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{id}/effectiveness", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public final void addCreatureEffectiveness(@PathVariable("id") long id, @RequestBody CreatureEffectivenessCreateDTO creatureEffectivenessCreateDTO) {
        logger.debug("rest addCreatureEffectiveness()");

        try {
           creatureFacade.addEffectiveWeapon(id, creatureEffectivenessCreateDTO);
        } catch (Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

    @RequestMapping(value = "/{id}/effectiveness/{effectiveness_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteCreatureEffectiveness(@PathVariable("id") long id, @PathVariable("effectiveness_id") long effectivenessId) {
        logger.debug("rest deleteCreatureEffectiveness()");

        try {
            creatureFacade.removeEffectiveWeapon(id, effectivenessId);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{id}/areas/{area_id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public final void addCreatureArea(@PathVariable("id") long id, @PathVariable("area_id") long areaId) {
        logger.debug("rest addCreatureArea()");

        try {
            creatureFacade.addAreaCreatureSpotted(id, areaId);
        } catch (Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

    @RequestMapping(value = "/{id}/areas/{area_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void removeCreatureEffectiveness(@PathVariable("id") long id, @PathVariable("area_id") long areaId) {
        logger.debug("rest removeAreaFromCreature()");

        try {
            creatureFacade.removeAreaCreatureSpotted(id, areaId);
        } catch (Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }
}
