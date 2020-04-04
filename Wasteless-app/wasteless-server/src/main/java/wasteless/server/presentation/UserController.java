package wasteless.server.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wasteless.server.exception.ResourceNotFoundException;
import wasteless.server.model.User;
import wasteless.server.persistance.UserRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUSerById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("activeUser")
    public User getActiveUser() {
        return userRepository.findFirstByActiveTrue();
    }

    @PostMapping("user/login")
    public ResponseEntity<User> loginUser(@Valid @RequestBody User loginUser) {
        List<User> allUsers = userRepository.findAll();
        Optional<User> matchingUser = allUsers
                .stream()
                .filter(user -> user.getEmailAddress().equals(loginUser.getEmailAddress()) &&
                        user.getPassword().equals(loginUser.getPassword()))
                .findFirst();
        return matchingUser.isPresent() ? ResponseEntity.ok(matchingUser.get()) :
                ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                                   @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setEmailAddress(userDetails.getEmailAddress());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
