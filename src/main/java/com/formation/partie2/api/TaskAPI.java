package com.formation.partie2.api;


import com.formation.partie2.modele.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskAPI {

    private final String BASE_URL = "http://localhost:8080";

    @Autowired
    private final RestTemplate restTemplate;

    public TaskAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/allTasks")
    public List<Task> getAllTasks() {
        ResponseEntity<List<Task>> response = restTemplate.exchange(
                BASE_URL + "/" + "task/allTasks",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Task>>() {}
        );
        return response.getBody();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        ResponseEntity<Task> response = restTemplate.getForEntity(
                BASE_URL + "/" + "task/"+ id,
                Task.class
        );
        return response.getBody();
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        ResponseEntity<Task> response = restTemplate.postForEntity(
                BASE_URL + "/" +"saveTask",
                task,
                Task.class
        );
        return response.getBody();
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) {
        restTemplate.put(
                BASE_URL + "/" + "task/update/" + id,
                task
        );
        return task;
    }

    @DeleteMapping("delete/{id}")
    public void deleteTask(@PathVariable int id) {
        restTemplate.delete(BASE_URL + "/" + "task/delete/" + id);
    }
}