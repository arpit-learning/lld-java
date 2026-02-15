package dev.arpit.BookMyShow.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class CreateTicketResponseDTO {
    private int id;
    private String movieTitle;
    private LocalDateTime showStartTime;
    private List<String> seatNumbers;
    private String auditoriumName;
    private String theatreName;

    public CreateTicketResponseDTO() {
    }

    public CreateTicketResponseDTO(int id, String movieTitle, LocalDateTime showStartTime, List<String> seatNumbers, String auditoriumName, String theatreName) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.showStartTime = showStartTime;
        this.seatNumbers = seatNumbers;
        this.auditoriumName = auditoriumName;
        this.theatreName = theatreName;
    }

    public int getId() {
        return id;
    }

    public CreateTicketResponseDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public CreateTicketResponseDTO setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
        return this;
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }

    public CreateTicketResponseDTO setShowStartTime(LocalDateTime showStartTime) {
        this.showStartTime = showStartTime;
        return this;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public CreateTicketResponseDTO setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
        return this;
    }

    public String getAuditoriumName() {
        return auditoriumName;
    }

    public CreateTicketResponseDTO setAuditoriumName(String auditoriumName) {
        this.auditoriumName = auditoriumName;
        return this;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public CreateTicketResponseDTO setTheatreName(String theatreName) {
        this.theatreName = theatreName;
        return this;
    }
}
