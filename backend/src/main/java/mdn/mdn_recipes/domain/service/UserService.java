package mdn.mdn_recipes.domain.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mdn.mdn_recipes.application.dto.user.UserRequest;
import mdn.mdn_recipes.application.dto.user.UserResponse;
import java.util.List;
import mdn.mdn_recipes.domain.model.User;
import mdn.mdn_recipes.infrastructure.repository.UserRepository;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, org.springframework.security.crypto.password.PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse create(UserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        String hash = passwordEncoder.encode(userRequest.getPassword());
        User user = new User(userRequest.getUsername(), hash);
        userRepository.save(user);
        return new UserResponse(user.getId(), user.getUsername());
    }

    public UserResponse getById(java.util.UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new UserResponse(user.getId(), user.getUsername());
    }

    public List<UserResponse> listAll() {
        return userRepository.findAll().stream()
                .map(u -> new UserResponse(u.getId(), u.getUsername()))
                .toList();
    }
}