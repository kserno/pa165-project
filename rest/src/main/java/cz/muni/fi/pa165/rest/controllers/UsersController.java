package cz.muni.fi.pa165.rest.controllers;

import cz.muni.fi.pa165.api.dto.user.*;
import cz.muni.fi.pa165.api.facade.UserFacade;
import cz.muni.fi.pa165.rest.ApiUris;
import cz.muni.fi.pa165.rest.exceptions.GlobalException;
import cz.muni.fi.pa165.rest.exceptions.ResourceAlreadyExistingException;
import cz.muni.fi.pa165.rest.exceptions.ResourceNotFoundException;
import cz.muni.fi.pa165.rest.exceptions.WrongCredentialsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(ApiUris.ROOT_URI_USERS)
public class UsersController {

    final static Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Inject
    private UserFacade userFacade;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final List<UserListDTO> getUsers(){
        logger.debug("rest getUsers");
        return userFacade.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final UserDTO getUser(@PathVariable("id") long id) {

        logger.debug("rest getUserById({})", id);

        UserDTO userDTO = userFacade.findUserById(id);
        if (userDTO == null){
            throw new ResourceNotFoundException();
        }
        return userDTO;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final UserDTO registerUser(@RequestBody UserRegisterDTO user) throws Exception {

        logger.debug("rest registerUser()");

        try {
            Long id = userFacade.registerUser(user);
            return userFacade.findUserById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final UserDTO authenticate(@RequestBody UserAuthenticateDTO user) {
        if (userFacade.authenticate(user)) {
            return userFacade.findUserByEmail(user.getEmail());
        } else {
            throw new WrongCredentialsException();
        }
    }

    @RequestMapping(value = "/changeImage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final UserDTO changeImage(@RequestBody UserChangeImageDTO user) throws Exception {
        logger.debug("rest changeImage()");

        try {
            userFacade.changeUserImage(user);
            return userFacade.findUserById(user.getUserId());
        } catch (Exception e){
            throw new GlobalException(e.getMessage());
        }
    }

}
