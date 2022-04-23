package mk.ukim.finki.elibrary.web.controller;


import mk.ukim.finki.elibrary.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public String getCountryPage(Model model){

        model.addAttribute("countries", this.countryService.findAll());
        model.addAttribute("bodyContent", "countries");
        return "master-template";
    }
}
