package dev.arpit.BookMyShow.dtos;

import java.util.List;

public class CreateTicketRequestDTO {
    private List<Integer> showSeatIds;
    private int userId;

    public CreateTicketRequestDTO() {
    }

    public CreateTicketRequestDTO(List<Integer> showSeatIds, int userId) {
        this.showSeatIds = showSeatIds;
        this.userId = userId;
    }

    public List<Integer> getShowSeatIds() {
        return showSeatIds;
    }

    public CreateTicketRequestDTO setShowSeatIds(List<Integer> showSeatIds) {
        this.showSeatIds = showSeatIds;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public CreateTicketRequestDTO setUserId(int userid) {
        this.userId = userid;
        return this;
    }
}
