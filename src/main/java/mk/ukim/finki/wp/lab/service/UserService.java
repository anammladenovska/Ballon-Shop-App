package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.model.UserFullname;

import java.time.LocalDate;


public interface UserService {
    User login(String username, String password);
    User register(String username, String userFullname, UserFullname password, LocalDate dateOfBirth);
}
