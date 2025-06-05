package com.assignment.blogappservice.controllers;

import com.assignment.blogappservice.dtos.*;
import com.assignment.blogappservice.models.Token;
import com.assignment.blogappservice.models.User;
import com.assignment.blogappservice.repositories.TokenRepository;
import com.assignment.blogappservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController
{
    @Autowired
    UserService userService;
    private final TokenRepository tokenRepository;
    public UserController(UserService userService , TokenRepository tokenRepository){

        this.userService = userService;
        this.tokenRepository = tokenRepository;
    }

    @PostMapping("/register")
    public UserDto signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        User user = userService.signUp(signUpRequestDto.getName() ,
                signUpRequestDto.getEmail(),
                signUpRequestDto.getPassword());
        return UserDto.from(user);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        Token token = userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setTokenValue(token.getValue());
        return loginResponseDto;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto logoutRequestDto)
    {
        return null;
    }

    @PostMapping("/validate/{token}")
    public ResponseEntity<Boolean> validateToken(@PathVariable("token") String token )
    {
        User user = userService.validateToken(token);
        ResponseEntity<Boolean> responseEntity ;

        if(user != null){
            responseEntity = new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
        else{
            responseEntity = new ResponseEntity<>(true, HttpStatus.OK);
        }
        return responseEntity;
    }

}
