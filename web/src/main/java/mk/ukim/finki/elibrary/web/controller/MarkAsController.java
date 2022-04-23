package mk.ukim.finki.elibrary.web.controller;

import mk.ukim.finki.elibrary.service.MarkAsService;
import mk.ukim.finki.elibrary.model.MarkAs;
import mk.ukim.finki.elibrary.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mark")
public class MarkAsController {

    private final MarkAsService markAsService;

    public MarkAsController(MarkAsService markAsService) {
        this.markAsService = markAsService;
    }


    @GetMapping
    public String getMarkAsPage(@RequestParam(required = false) String error,
                                      HttpServletRequest req,
                                      Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        String username = req.getRemoteUser();
        MarkAs mark = this.markAsService.getActiveMarkAs(username);
        model.addAttribute("books", this.markAsService.listAllBooksInMarkAs(mark.getId()));
        model.addAttribute("bodyContent","mark");
        return "master-template";
    }

    @PostMapping("/add-book/{id}")
    public String addBookToMarkAs(@PathVariable Long id, HttpServletRequest req, Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();
            this.markAsService.addBookToMarkAs(user.getUsername(), id);
            return "redirect:/mark";
        } catch (RuntimeException exception) {
            return "redirect:/mark?error=" + exception.getMessage();
        }
    }
}
