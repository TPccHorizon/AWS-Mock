package ch.confinale.aws.ch.confinale.aws.controllers;

import ch.confinale.aws.ch.confinale.aws.models.User;
import ch.confinale.aws.ch.confinale.aws.security.TokenValidator;
import ch.confinale.aws.ch.confinale.aws.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/whoAmI", method = RequestMethod.GET)
    public User findByName(@CookieValue(value = "SAML_ASSERTION") String samlToken) {
        logger.info("Cookie: " + samlToken);
        TokenValidator tokenValidator = new TokenValidator();
        if (tokenValidator.isTokenValid(samlToken)) {
            return userService.getUser();
        } else {
            return null;
        }
    }
}
