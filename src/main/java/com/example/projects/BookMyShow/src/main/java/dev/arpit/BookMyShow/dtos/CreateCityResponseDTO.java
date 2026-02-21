package dev.arpit.BookMyShow.dtos;

public class CreateCityResponseDTO {
    private int id;
    private String name;

    public CreateCityResponseDTO() {
    }

    public CreateCityResponseDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public CreateCityResponseDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateCityResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
