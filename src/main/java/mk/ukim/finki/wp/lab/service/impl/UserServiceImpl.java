package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.model.UserFullname;
import mk.ukim.finki.wp.lab.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.wp.lab.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.wp.lab.repository.jpa.UserRepository;
import mk.ukim.finki.wp.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidArgumentException::new);
    }

    @Override
    public User register(String username, String password, UserFullname userFullname, LocalDate dateOfBirth) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentException();
        }


        if(this.userRepository.findByUsername(username).isPresent()
                || !this.userRepository.findByUsername(username).isEmpty())
            throw new UsernameAlreadyExistsException(username);
        User user = new User( username,  userFullname,  password,dateOfBirth );
        return userRepository.save(user);

    }
}
