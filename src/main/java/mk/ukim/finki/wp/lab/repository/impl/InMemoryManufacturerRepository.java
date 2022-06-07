package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Repository
public class

InMemoryManufacturerRepository {
    public List<Manufacturer> manufacturers = new ArrayList<>(5);

    public InMemoryManufacturerRepository() {
        manufacturers.add(new Manufacturer("SuperStileBallon","France","Avenue des Champs-Élysées"));
        manufacturers.add(new Manufacturer("SuperStileBallo2n","France","Avenue des Champs-Élysées"));
        manufacturers.add(new Manufacturer("SuperStileBallon3","France","Avenue des Champs-Élysées"));
        manufacturers.add(new Manufacturer("SuperStileBallon4","France","Avenue des Champs-Élysées"));
        manufacturers.add(new Manufacturer("SuperStileBallon5","France","Avenue des Champs-Élysées"));
    }

    public List<Manufacturer> findAll(){
        return manufacturers;
    }

    public Optional<Manufacturer> findById(Long id){
        return manufacturers.stream().filter(r->r.getId().equals(id)).findFirst();
    }

    public void deleteId(Long id){
        manufacturers.removeIf(r->r.getId().equals(id));
    }

    public Optional<Manufacturer> saveManufacturer( String name, String country, String address){
        manufacturers.removeIf(r->r.getName().equals(name));
        Manufacturer manufacturer = new Manufacturer(name, country, address);
        manufacturers.add(manufacturer);
        return Optional.of(manufacturer);
    }

    public void editManufacturer(Long id, String name, String country, String address){
        for(Manufacturer manufacturer : manufacturers)
            if(manufacturer.getId().equals(id)){
                manufacturer.setName(name);
                manufacturer.setCountry(country);
                manufacturer.setAddress(address);
            }
    }
}
