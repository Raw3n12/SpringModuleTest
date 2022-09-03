package app.services;

import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceShipService {

    private SpaceShipRepo spaceShipRepo;

    @Autowired
    public SpaceShipService(SpaceShipRepo spaceShipRepo){
        this.spaceShipRepo=spaceShipRepo;

    }

    public List<SpaceShip> getAllSpaceship(){
        return (List<SpaceShip>) spaceShipRepo.findAll();

    }
    public List<SpaceShip> getByActive(){
        List<SpaceShip> activeresult = new ArrayList<>();
        for (SpaceShip ship: getAllSpaceship()){
            if (ship.isActive()){
                activeresult.add(ship);
            }
            } return activeresult;




}}
