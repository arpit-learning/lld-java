package dev.arpit.BookMyShow.dtos;

import java.util.List;

public class CreateUserResponseDTO {
    private int id;
    private String name;
    private String email;
    private List<CreateTicketResponseDTO> tickets;

    public CreateUserResponseDTO() {
    }

    public CreateUserResponseDTO(int id, String name, String email, List<CreateTicketResponseDTO> tickets) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public CreateUserResponseDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateUserResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<CreateTicketResponseDTO> getTickets() {
        return tickets;
    }

    public CreateUserResponseDTO setTickets(List<CreateTicketResponseDTO> tickets) {
        this.tickets = tickets;
        return this;
    }
}
