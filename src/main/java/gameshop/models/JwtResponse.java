package gameshop.models;

import gameshop.models.entities.Role;

import java.util.List;

public class JwtResponse {

    private String jwt;
    private String login;
    private List<Role> roles;


    public JwtResponse(String jwt, String login, List<Role> roles) {
        this.jwt = jwt;
        this.login = login;
        this.roles = roles;
    }

    public String getJwt() {
        return jwt;
    }

    public String getLogin() {
        return login;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
