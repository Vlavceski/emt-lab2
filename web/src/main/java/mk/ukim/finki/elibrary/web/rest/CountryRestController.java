package mk.ukim.finki.elibrary.web.rest;

import mk.ukim.finki.elibrary.service.CountryService;
import mk.ukim.finki.elibrary.model.Country;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping
    public List<Country> findAll() {
        return this.countryService.findAll();
    }
}

//
//    @GetMapping("/{id}")
//    public ResponseEntity<Country> findById(@PathVariable Long id) {
//        return this.manufacturerService.findById(id)
//                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<Country> save(@RequestParam String name, @RequestParam String address) {
//        return this.manufacturerService.save(name, address)
//                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteById(@PathVariable Long id) {
//        this.manufacturerService.deleteById(id);
//        if(this.manufacturerService.findById(id).isEmpty()) return ResponseEntity.ok().build();
//        return ResponseEntity.badRequest().build();
//    }

