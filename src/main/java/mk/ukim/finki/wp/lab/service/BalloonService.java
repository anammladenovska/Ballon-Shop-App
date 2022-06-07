package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> findById(Long id);
    Optional<Balloon> saveBalloon(String name, String description, Long manufacturerId);
    void deleteById(Long id);
    String sendColor(String name);
    void edit(Long id, String name, String description, Long manufacturerId);
}
