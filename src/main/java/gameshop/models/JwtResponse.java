package gameshop.models;

import gameshop.models.entities.Role;

import java.util.List;

public class JwtResponse {

    String jwt;
    String login;
    List<Role> roles;


    public JwtResponse(String jwt, String login, List<Role> roles) {
        this.jwt = jwt;
        this.login = login;
        this.roles = roles;
    }
}
