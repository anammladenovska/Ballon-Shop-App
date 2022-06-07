package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getManufacturerPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasErrors", true);
            model.addAttribute("error", error);
        }
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers",manufacturers);
        return "listManufacturers";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteManufacturer(@PathVariable Long id){
        if(id!=null)
            this.manufacturerService.deleteId(id);
        return "redirect:/manufacturers";
    }

    @GetMapping("/add-form")
    public String getAddManufacturerPage(){
        return "add-manufacturer";
    }

    @PostMapping("/add")
    public String saveManufacturer(@RequestParam String name,
                                   @RequestParam String country,
                                   @RequestParam String address){

            this.manufacturerService.saveManufacturer(name, country,address);
            return "redirect:/manufacturers";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditManufacturerPage(@PathVariable Long id, Model model){
        if(this.manufacturerService.findById(id).isPresent()){
            Manufacturer manufacturer = this.manufacturerService.findById(id).get();
            model.addAttribute("manufacturer", manufacturer);
            return "edit-manufacturer";
        }
        return "redirect:/manufacturers?error=ManufacturerNotFound";
    }

//    @PostMapping("/edit")
//    public String editManufacturer(@PathVariable Long id,
//                                    @RequestParam String name,
//                                   @RequestParam String country,
//                                   @RequestParam String address){
//
//        this.manufacturerService.editManufacturer(id, name, country,address);
//        return "redirect:/manufacturers";
//    }
}
