package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Balloon {
    @Id
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private Manufacturer manufacturer;

    public Balloon(String name, String description,
                   Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Balloon() {

    }
}
