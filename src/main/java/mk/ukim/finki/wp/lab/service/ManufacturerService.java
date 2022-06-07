package mk.ukim.finki.wp.lab.service;


import mk.ukim.finki.wp.lab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    public List<Manufacturer> findAll();
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> saveManufacturer(String name, String country, String address);
    void deleteId(Long id);
//    void editManufacturer(Long id, String name, String country, String address);
}
