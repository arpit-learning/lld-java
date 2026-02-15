package dev.arpit.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "bms_user")
public class User extends BaseModel {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Ticket> tickets;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public User setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
        return this;
    }
}
