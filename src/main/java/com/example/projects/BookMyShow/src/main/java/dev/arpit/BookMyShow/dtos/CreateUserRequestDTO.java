package dev.arpit.BookMyShow.dtos;

public class CreateUserRequestDTO {
    private String name;
    private String email;
    private String password;

    public CreateUserRequestDTO() {
    }

    public CreateUserRequestDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public CreateUserRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreateUserRequestDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
