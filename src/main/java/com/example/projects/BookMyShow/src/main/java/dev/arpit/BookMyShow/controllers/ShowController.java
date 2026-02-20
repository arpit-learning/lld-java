package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.dtos.*;
import dev.arpit.BookMyShow.exceptions.InvalidCreateShowRequestDTOException;
import dev.arpit.BookMyShow.exceptions.InvalidCreateShowSeatRequestDTOException;
import dev.arpit.BookMyShow.mappers.ShowDTOMapper;
import dev.arpit.BookMyShow.models.Show;
import dev.arpit.BookMyShow.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping("/show")
    public ResponseEntity<ResponseDTO<CreateShowResponseDTO>> crateShowSeat(@RequestBody CreateShowRequestDTO requestDTO) {
        ResponseDTO<CreateShowResponseDTO> responseDTO = new ResponseDTO<>();

        try {
            doValidations(requestDTO);
            int movieId = requestDTO.getMovieId();
            int auditoriumId = requestDTO.getAuditoriumId();
            String showStartTime = requestDTO.getShowStartTime();
            String showEndTime = requestDTO.getShowEndTime();
            List<String> featuresStr = requestDTO.getFeatures();

            Show show = showService.createShow(movieId,auditoriumId,showStartTime, showEndTime, featuresStr);
            responseDTO.setData(
                    ShowDTOMapper.getCreateShowResponseDTO(show)
            ).setMeta(
                    new MetaDataDTO(
                            "success",
                            ResponseCode.SC_200,
                            "Show created successfully"
                    )
            );
        } catch(Exception e) {
            responseDTO.setMeta(
                    new MetaDataDTO(
                            e.getMessage(),
                            ResponseCode.ER_400,
                            e.getMessage()
                    )
            );
        }

        return ResponseEntity.ok(responseDTO);
    }

    private void doValidations(CreateShowRequestDTO requestDTO) throws InvalidCreateShowRequestDTOException {
        if(requestDTO == null) {
            throw new InvalidCreateShowRequestDTOException("request data can not be null.", ResponseCode.ER_400, "Invalid request data");
        }
        if(requestDTO.getMovieId() == null) {
            throw new InvalidCreateShowRequestDTOException("MovieId can not be null.", ResponseCode.ER_400, "Invalid MovieId");
        }
        if(requestDTO.getAuditoriumId() == null) {
            throw new InvalidCreateShowRequestDTOException("AuditoriumId can not be null.", ResponseCode.ER_400, "Invalid AuditoriumId");
        }
        if(requestDTO.getShowStartTime() == null) {
            throw new InvalidCreateShowRequestDTOException("ShowStartTime can not be null.", ResponseCode.ER_400, "Invalid ShowStartTime");
        }
        if(requestDTO.getShowEndTime() == null) {
            throw new InvalidCreateShowRequestDTOException("ShowEndTime can not be null.", ResponseCode.ER_400, "Invalid ShowEndTime");
        }
    }
}
