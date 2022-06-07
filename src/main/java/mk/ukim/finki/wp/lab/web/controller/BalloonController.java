package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.service.BalloonService;
import mk.ukim.finki.wp.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/balloons", method ={RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET} )
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasErrors", true);
            model.addAttribute("error",error);
        }
        List<Balloon> balloons = this.balloonService.listAll();
        model.addAttribute("balloons", balloons);
        return "listBalloons";
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "add-balloon";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model){
        if(this.balloonService.findById(id).isPresent()){
            Balloon balloon = this.balloonService.findById(id).get();
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("balloon", balloon);
            return "edit-balloon";
        }
        return "redirect:/balloons?error=BalloonNotFound";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        if(id!=null)
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturer){
        this.balloonService.saveBalloon(name, description, manufacturer);
        return "redirect:/balloons";
    }

    @PostMapping("/edit")
    public String editBalloon(@RequestParam Long id,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturer){

        this.balloonService.edit(id, name, description, manufacturer);
        return "redirect:/balloons";
    }

    @PostMapping("/size")
    public String redirectToSelectSize(HttpServletRequest request, HttpServletResponse response){
        if(request.getParameter("color") == null){
            return "redirect:/balloons?error=No%20Balloon%20selected";
        }
        String color = request.getParameter("color");
        request.getSession().setAttribute("color", color);
        return "redirect:/selectBalloon";
    }

}
