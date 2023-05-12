package com.formation.partie2.api;

import com.formation.partie2.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserAPI {

    private final String BASE_URL = "http://localhost:8080";

    @Autowired
    private final RestTemplate restTemplate;

    public UserAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {dzdzadd
        ResponseEntity<List<User>> response = restTemplate.exchange(
                BASE_URL+ "/" +"user/getAllUsers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {}
        );
        return response.getBody();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        ResponseEntity<User> response = restTemplate.getForEntity(
                BASE_URL + "/" +"user/"+ id,
                User.class
        );
        return response.getBody();
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        /*
        ResponseEntity<User> response = restTemplate.postForEntity(
                BASE_URL+ "/" + "user/save",
                user,
                User.class
        );
         */
        return restTemplate.postForObject( BASE_URL+ "/" + "user/save", user, User.class );
        /*return response.getBody();*/
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        restTemplate.put(
                BASE_URL + "/" + "user/update/"+ id,
                user
        );
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        restTemplate.delete(BASE_URL + "/" +"user/delete/"+ id);
    }
}
