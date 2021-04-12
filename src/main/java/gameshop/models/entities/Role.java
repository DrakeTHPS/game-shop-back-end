package gameshop.models.entities;

public enum Role {

    ADMIN("Admin"),
    USER("User");

    private final String role;

    Role(String role) {
        this.role = role;
    }
}