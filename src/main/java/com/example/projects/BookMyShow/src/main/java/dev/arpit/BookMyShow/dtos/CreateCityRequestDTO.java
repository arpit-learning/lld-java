package dev.arpit.BookMyShow.dtos;

public class CreateCityRequestDTO {
    private String name;

    public CreateCityRequestDTO() {
    }

    public CreateCityRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CreateCityRequestDTO setName(String name) {
        this.name = name;
        return this;
    }
}
