package ch.confinale.aws.ch.confinale.aws.services;

import ch.confinale.aws.ch.confinale.aws.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser() {
        return new User("Carlos Schweizer", "carlos.schweizer@confinale.ch");
    }
}
