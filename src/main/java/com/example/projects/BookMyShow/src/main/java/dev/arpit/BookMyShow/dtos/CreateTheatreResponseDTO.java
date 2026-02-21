package dev.arpit.BookMyShow.dtos;

public class CreateTheatreResponseDTO {
    private int id;
    private String name;
    private String address;

    public CreateTheatreResponseDTO() {
    }

    public CreateTheatreResponseDTO(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public CreateTheatreResponseDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateTheatreResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CreateTheatreResponseDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}

