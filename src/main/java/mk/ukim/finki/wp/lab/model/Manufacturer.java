package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Manufacturer {
    @Id
    private Long id;
    private String name;
    private String country;
    @Column(name = "manufacturer_address")
    private String address;

    public Manufacturer(String name, String country, String address) {
        this.name = name;
        this.country = country;
        this.address = address;
    }

    public Manufacturer() {

    }
}
