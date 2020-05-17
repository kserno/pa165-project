package cz.muni.fi.pa165.rest.controllers;

import cz.muni.fi.pa165.api.dto.weapon.*;
import cz.muni.fi.pa165.api.facade.WeaponFacade;
import cz.muni.fi.pa165.rest.ApiUris;
import cz.muni.fi.pa165.rest.exceptions.ResourceAlreadyExistingException;
import cz.muni.fi.pa165.rest.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(ApiUris.ROOT_URI_WEAPONS)
public class WeaponsController {

    final static Logger logger = LoggerFactory.getLogger(WeaponsController.class);

    @Inject
    private WeaponFacade weaponFacade;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final List<WeaponListDTO> getWeapons(){
        logger.debug("rest getWeapons");
        return weaponFacade.getAllWeapons();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final WeaponDTO getWeapon(@PathVariable("id") long id) {

        logger.debug("rest getWeaponById({})", id);

        WeaponDTO weaponDTO = weaponFacade.getWeaponById(id);
        if (weaponDTO == null){
            throw new ResourceNotFoundException();
        }
        return weaponDTO;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final WeaponDTO createWeapon(@RequestBody WeaponCreateDTO weapon) throws Exception {

        logger.debug("rest createProduct()");

        try {
            Long id = weaponFacade.createWeapon(weapon);
            return weaponFacade.getWeaponById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final WeaponDTO updateWeapon(@PathVariable("id") long id, @RequestBody WeaponUpdateDTO weapon) {
        logger.debug("rest updateWeapon()");

        try {
            weaponFacade.updateWeapon(weapon);
            return weaponFacade.getWeaponById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteWeapon(@PathVariable("id") long id) {
        logger.debug("rest deleteWeapon()");

        try {
            weaponFacade.deleteWeapon(id);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{id}/effectiveness", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public final void addWeaponEffectiveness(@PathVariable("id") long id, @RequestBody WeaponEffectivenessCreateDTO weaponEffectivenessCreateDTO) {
        logger.debug("rest deleteWeaponEffectiveness()");

        try {
            weaponFacade.addWeaponEffectiveness(id, weaponEffectivenessCreateDTO);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{id}/effectiveness/{effectiveness_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteWeaponEffectiveness(@PathVariable("id") long id, @PathVariable("effectiveness_id") long effectivenessId) {
        logger.debug("rest deleteWeaponEffectiveness()");

        try {
            weaponFacade.removeWeaponEffectiveness(id, effectivenessId);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }




}
