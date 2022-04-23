package mk.ukim.finki.elibrary.service;

import mk.ukim.finki.elibrary.model.User;

public interface AuthService {
    User login(String username, String password);
}
