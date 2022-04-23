package mk.ukim.finki.elibrary.web.rest;

import mk.ukim.finki.elibrary.service.AuthorService;
import mk.ukim.finki.elibrary.model.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return this.authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}


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

