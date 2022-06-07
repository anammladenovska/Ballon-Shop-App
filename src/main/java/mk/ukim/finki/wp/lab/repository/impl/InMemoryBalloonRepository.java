package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBalloonRepository {

    public List<Balloon> balloonList = new ArrayList<>(10);
    private final InMemoryManufacturerRepository manufacturerRepository;

    public InMemoryBalloonRepository(InMemoryManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
        balloonList.add(new Balloon("Black","Black Balloon",manufacturerRepository.findAll().get(0)));
        balloonList.add(new Balloon("White","White Balloon",manufacturerRepository.findAll().get(1)));
        balloonList.add(new Balloon("Pink","Pink Balloon",manufacturerRepository.findAll().get(2)));
        balloonList.add(new Balloon("Red","Red Balloon",manufacturerRepository.findAll().get(3)));
        balloonList.add(new Balloon("Purple","Purple Balloon",manufacturerRepository.findAll().get(4)));
        balloonList.add(new Balloon("Blue","Blue Balloon",manufacturerRepository.findAll().get(0)));
        balloonList.add(new Balloon("Baby-blue","Baby-blue Balloon",manufacturerRepository.findAll().get(1)));
        balloonList.add(new Balloon("Orange","Orange Balloon",manufacturerRepository.findAll().get(2)));
        balloonList.add(new Balloon("Green","Green Balloon",manufacturerRepository.findAll().get(3)));
        balloonList.add(new Balloon("Grey","Grey Balloon",manufacturerRepository.findAll().get(4)));
    }

    public List<Balloon> findAllBalloons(){
        return balloonList;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        balloonList.stream().filter(r->r.getName().equals(text) || r.getDescription().equals(text)).findFirst();
        return balloonList;
    }

    public Optional<Balloon> findById(Long id){
       return balloonList.stream().filter(r->r.getId().equals(id)).findFirst();
    }

    public Optional<Balloon> saveBalloon(String name, String description, Manufacturer manufacturer){
        balloonList.removeIf(r->r.getName().equals(name));
        Balloon balloon = new Balloon(name, description, manufacturer);
        balloonList.add(balloon);
        return Optional.of(balloon);
    }

    public void deleteById(Long id){
        balloonList.removeIf(r->r.getId().equals(id));
    }

    public String sendColor(String name){
         balloonList.stream().filter(r->r.getName().equals(name));
        return name;
    }

    public void edit(Long id, String name, String description, Manufacturer manufacturer){
        for(Balloon balloon : balloonList)
        {
            if (balloon.getId().equals(id)) {
                balloon.setName(name);
                balloon.setDescription(description);
                balloon.setManufacturer(manufacturer);
            }
        }
    }
}









