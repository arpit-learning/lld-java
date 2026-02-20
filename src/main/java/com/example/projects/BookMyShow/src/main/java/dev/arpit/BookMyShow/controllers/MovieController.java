package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.dtos.*;
import dev.arpit.BookMyShow.exceptions.BaseException;
import dev.arpit.BookMyShow.exceptions.InvalidCreateMovieRequestDTOException;
import dev.arpit.BookMyShow.mappers.MovieDTOMapper;
import dev.arpit.BookMyShow.models.Movie;
import dev.arpit.BookMyShow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
    public ResponseEntity<ResponseDTO<CreateMovieResponseDTO>> createMovie(@RequestBody CreateMovieRequestDTO requestDTO) {
        ResponseDTO<CreateMovieResponseDTO> responseDTO = new ResponseDTO<>();

        try {
            doValidations(requestDTO);
            Movie movie = MovieDTOMapper.getMovie(requestDTO);
            movie = movieService.save(movie);
            responseDTO.setData(
                    MovieDTOMapper.getCreateMovieResponseDTO(movie)
            ).setMeta(
                    new MetaDataDTO(
                            "success",
                            ResponseCode.SC_200,
                            "Movie created successfully"
                    )
            );
        } catch (BaseException e) {
            responseDTO.setMeta(
                    new MetaDataDTO(
                            e.getMessage(),
                            e.getCode(),
                            e.getDisplayMessage()
                    ));
        }

        return ResponseEntity.ok(responseDTO);
    }

    private void doValidations(CreateMovieRequestDTO requestDTO) throws InvalidCreateMovieRequestDTOException {
        if(requestDTO == null) {
            throw new InvalidCreateMovieRequestDTOException("Request body can not be null", ResponseCode.ER_400, "Invalid request body");
        }
        if(requestDTO.getTitle() == null) {
            throw new InvalidCreateMovieRequestDTOException("Title can not be null", ResponseCode.ER_400, "Invalid title");
        }
        if(requestDTO.getUrl() == null) {
            throw new InvalidCreateMovieRequestDTOException("Url can not be null", ResponseCode.ER_400, "Invalid url");
        }
    }
}
