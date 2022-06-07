package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name="shop.users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Convert(converter = UserFullnameConverter.class)
    private UserFullname userFullname;

    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ShoppingCart> carts;

    public User(String username, UserFullname userFullname,  String password, LocalDate dateOfBirth) {
        this.username = username;
//        this.name = name;
//        this.surname = surname;
        this.userFullname = userFullname;
        this.password = password;
        this.dateOfBirth = LocalDate.now();
    }

    public User() {

    }
}
