package com.myplace.letsgo.controller;

import com.myplace.letsgo.business.abstracts.CustomerService;
import com.myplace.letsgo.dto.AuthResponse;
import com.myplace.letsgo.dto.UserRequest;
import com.myplace.letsgo.models.Customer;
import com.myplace.letsgo.security.JwtTokenProvider;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final CustomerService customerService;

    private final PasswordEncoder passwordEncoder;

   // public AuthenticationController(){}

    
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
            CustomerService customerService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.customerService = customerService;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/login")
    public AuthResponse login(@RequestBody UserRequest request){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        
        Customer customer = customerService.getOneCustomerByUserName(request.getUserName());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setMessage("Bearer " + jwtToken);
        authResponse.setUserId(customer.getId());
        return  authResponse ;
    }

    @PostMapping("/register")
    public  ResponseEntity<AuthResponse> register(@RequestBody UserRequest request){
        AuthResponse authResponse = new AuthResponse();
        if(customerService.getOneCustomerByUserName(request.getUserName()) != null ){
            //boyle bır kullanıcı var hata döneriz
            authResponse.setMessage("Username alaready taken");
            return new ResponseEntity<>(authResponse,HttpStatus.BAD_REQUEST);
        }

        Customer customer = new Customer();
            customer.setUserName(request.getUserName());
            customer.setPassword(passwordEncoder.encode(request.getPassword()));
            customer.setEmail(request.getEmail());

            customerService.saveOneCustomer(customer);
            authResponse.setMessage("User succesfully registered");
            return new ResponseEntity<>( authResponse ,HttpStatus.CREATED);

    }


}
