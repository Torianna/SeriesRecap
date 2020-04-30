import com.seriesrecap.SeriesRecap.Entites.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seriesRecap/users")
@CrossOrigin("*")

public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userDTOs = userService.getAllUsers();


        return userDTOs.isEmpty() ? new ResponseEntity<>(userDTOs, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);


        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.saveUser(user);
        User user = new User(user.getId(), user.getName(), user.getSurname(), user.getPassword());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
