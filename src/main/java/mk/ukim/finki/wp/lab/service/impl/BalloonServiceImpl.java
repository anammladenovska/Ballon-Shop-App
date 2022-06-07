package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.model.exceptions.ManufacturerNotFoundException;
import mk.ukim.finki.wp.lab.repository.jpa.BalloonRepository;
import mk.ukim.finki.wp.lab.repository.jpa.ManufacturerRepository;
import mk.ukim.finki.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    private final ManufacturerRepository manufacturerRepository;


    @Override
    public List<Balloon> listAll() {
       return balloonRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAll().stream().filter(r->r.getName().equals(text) || r.getDescription().contains(text)).collect(Collectors.toList());
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return this.balloonRepository.findById(id);
    }

    @Override
    public Optional<Balloon> saveBalloon(String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
        this.balloonRepository.deleteByName(name);

        return Optional.of(this.balloonRepository.save(new Balloon(name, description, manufacturer)));
    }

    @Override
    public void deleteById(Long id) {
        this.balloonRepository.deleteById(id);
    }

    @Override
    public String sendColor(String name) {
        balloonRepository.findAll().stream().filter(r->r.getName().equals(name));
        return name;
    }

    @Override
    public void edit(Long id, String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
        balloonRepository.deleteById(id);
        Balloon balloon = new Balloon(name, description,  manufacturer);
        balloonRepository.save(balloon);
    }
}
