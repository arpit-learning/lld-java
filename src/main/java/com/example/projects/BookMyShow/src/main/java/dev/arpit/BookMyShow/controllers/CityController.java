package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.dtos.*;
import dev.arpit.BookMyShow.exceptions.BaseException;
import dev.arpit.BookMyShow.exceptions.InvalidCreateCityRequestDTOException;
import dev.arpit.BookMyShow.mappers.CityDTOMapper;
import dev.arpit.BookMyShow.models.City;
import dev.arpit.BookMyShow.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public ResponseEntity<ResponseDTO<CreateCityResponseDTO>> createCity(@RequestBody CreateCityRequestDTO requestDTO) {
        ResponseDTO<CreateCityResponseDTO> responseDTO = new ResponseDTO<>();

        try {
            doValidations(requestDTO);
            City city = CityDTOMapper.getCity(requestDTO);
            city = cityService.save(city);
            responseDTO.setData(CityDTOMapper.getCreateCityResponseDTO(city)).setMeta(
                new MetaDataDTO(
                    "success",
                    ResponseCode.SC_200,
                    "City created successfully"
                )
            );
        } catch(BaseException e) {
            responseDTO.setMeta(
                new MetaDataDTO(
                    e.getMessage(),
                    e.getCode(),
                    e.getDisplayMessage()
                )
            );
        }

        return ResponseEntity.ok(responseDTO);
    }

    private void doValidations(CreateCityRequestDTO requestDTO) throws InvalidCreateCityRequestDTOException {
        if(requestDTO == null) {
            throw new InvalidCreateCityRequestDTOException("Request body can not be null", ResponseCode.ER_400, "Invalid request body");
        }
        if(requestDTO.getName() == null || requestDTO.getName().isEmpty()) {
            throw new InvalidCreateCityRequestDTOException("City name can not be empty", ResponseCode.ER_400, "Invalid city name");
        }
    }
}
