package dev.arpit.BookMyShow.dtos;

public class CreateTheatreRequestDTO {
    private String name;
    private String address;

    public CreateTheatreRequestDTO() {
    }

    public CreateTheatreRequestDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public CreateTheatreRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CreateTheatreRequestDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}
