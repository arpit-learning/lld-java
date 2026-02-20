package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.dtos.*;
import dev.arpit.BookMyShow.exceptions.BaseException;
import dev.arpit.BookMyShow.exceptions.InvalidCreateUserRequestDTOException;
import dev.arpit.BookMyShow.mappers.UserDTOMapper;
import dev.arpit.BookMyShow.models.User;
import dev.arpit.BookMyShow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<ResponseDTO<CreateUserResponseDTO>> createUser(@RequestBody CreateUserRequestDTO requestDTO) {
        ResponseDTO<CreateUserResponseDTO> responseDTO = new ResponseDTO<>();

        try {
            doCreateUserValidations(requestDTO);
            User user = userService.createUser(UserDTOMapper.getUser(requestDTO));
            responseDTO.setMeta(new MetaDataDTO(
                    "Success",
                    ResponseCode.SC_200,
                    "User created successfully"
            ))
                    .setData(UserDTOMapper.getCreateUserResponseDTO(user));
        } catch(BaseException e) {
            responseDTO.setMeta(new MetaDataDTO(
                    e.getMessage(),
                    e.getCode(),
                    e.getMessage()
            ));
        }

        return ResponseEntity.ok(responseDTO);
    }

    private void doCreateUserValidations(CreateUserRequestDTO requestDTO) throws InvalidCreateUserRequestDTOException {
        if(requestDTO == null) {
            throw new InvalidCreateUserRequestDTOException("Request payload can not be null", ResponseCode.ER_400, "Invalid request payload");
        }
        if(requestDTO.getName() == null || requestDTO.getName().isEmpty()) {
            throw new InvalidCreateUserRequestDTOException("Name can not be empty", ResponseCode.ER_400, "Invalid Name");
        }
        if(requestDTO.getEmail() == null || requestDTO.getEmail().isEmpty()) {
            throw new InvalidCreateUserRequestDTOException("Email can not be empty", ResponseCode.ER_400, "Invalid Email");
        }
        if(requestDTO.getPassword() == null || requestDTO.getPassword().isEmpty()) {
            throw new InvalidCreateUserRequestDTOException("Password can not be empty", ResponseCode.ER_400, "Invalid Password");
        }
    }
}
