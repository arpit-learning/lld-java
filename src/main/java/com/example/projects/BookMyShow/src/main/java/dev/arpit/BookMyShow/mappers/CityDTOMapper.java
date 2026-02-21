package dev.arpit.BookMyShow.mappers;

import dev.arpit.BookMyShow.dtos.CreateCityRequestDTO;
import dev.arpit.BookMyShow.dtos.CreateCityResponseDTO;
import dev.arpit.BookMyShow.models.City;

public class CityDTOMapper {
    public static City getCity(CreateCityRequestDTO requestDTO) {
        City city = new City();
        city.setName(requestDTO.getName());
        return city;
    }

    public static CreateCityResponseDTO getCreateCityResponseDTO(City city) {
        CreateCityResponseDTO responseDTO = new CreateCityResponseDTO();
        responseDTO.setId(city.getId());
        responseDTO.setName(city.getName());
        return responseDTO;
    }
}
