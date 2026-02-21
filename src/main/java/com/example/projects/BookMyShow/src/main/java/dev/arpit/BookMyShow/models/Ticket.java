package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.TicketStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ticket extends BaseModel {
    @OneToOne
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    public User getUser() {
        return user;
    }

    public Ticket setUser(User user) {
        this.user = user;
        return this;
    }

    public Show getShow() {
        return show;
    }

    public Ticket setShow(Show show) {
        this.show = show;
        return this;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public Ticket setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
        return this;
    }

    public Payment getPayment() {
        return payment;
    }

    public Ticket setPayment(Payment payment) {
        this.payment = payment;
        return this;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public Ticket setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
        return this;
    }
}
