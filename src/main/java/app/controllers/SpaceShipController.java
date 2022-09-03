package app.controllers;

import app.models.Crew;
import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.repositories.CrewRepo;
import app.repositories.SpaceShipRepo;
import app.services.OfficerService;
import app.services.SpaceShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SpaceShipController {

    @Autowired
    private SpaceShipRepo spaceShipRepo;
    @Autowired
    private CrewRepo crewRepo;

    @Autowired
    private SpaceShipService spaceShipService;

    @Autowired
    private SpaceShipController(SpaceShipRepo spaceShipRepo){
        this.spaceShipRepo=spaceShipRepo;
    }
    public SpaceShipController(CrewRepo crewRepo) {
        this.crewRepo = crewRepo;
    }

    public SpaceShipController(SpaceShipService spaceShipService) {
        this.spaceShipService = spaceShipService;
    }


    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }

    @GetMapping(value = {"/spaceshiplist"})
    public String spaceshipInfo(Model model) {
        List<SpaceShip> spaceShipList = (List<SpaceShip>) spaceShipRepo.findAll();
        model.addAttribute("spaceshiplist", spaceShipList);

        return "spaceshiplist";
    }

    @GetMapping(value = {"/serviceactive"})
    public String result(Model model) {
        List<SpaceShip> ship = spaceShipService.getByActive();
        model.addAttribute("ship", ship);
        return "serviceactive";
    }

    @GetMapping(value = {"servicecrew"})
    public String crews(Model model){
    List<Crew> crews = (List<Crew>) crewRepo.findAll();
        model.addAttribute("crew", crews);
        return "servicecrew";

    }
}
