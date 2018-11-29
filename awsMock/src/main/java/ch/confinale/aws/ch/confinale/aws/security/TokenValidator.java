package ch.confinale.aws.ch.confinale.aws.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenValidator {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public boolean isTokenValid(String samlToken) {
        if (samlToken != null){
            logger.info("SAML_TOKEN is received");
            return true;
        } else {
            logger.info("no Token provided");
            return false;
        }
    }
}
