package mdn.mdn_recipes.application.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mdn.mdn_recipes.application.dto.user.UserRequest;
import mdn.mdn_recipes.application.dto.user.UserResponse;
import mdn.mdn_recipes.domain.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create (@RequestBody UserRequest userRequest) {
        UserResponse created = userService.create(userRequest);
        return ResponseEntity.created(URI.create("/users/" + created.id())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse>  get(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<java.util.List<UserResponse>> list() {
        return ResponseEntity.ok(userService.listAll());
    }
}
