package jpmc.hackathon.usermanagement;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class FakeController {


    @GetMapping(path = "/list")
    public List<User> list() {
        return Stream.of(
                new User(UUID.randomUUID().toString(),UUID.randomUUID().toString(), "Rib", "Fine", false),
                new User(UUID.randomUUID().toString(),UUID.randomUUID().toString(), "222", "22222", false),
                new User(UUID.randomUUID().toString(),UUID.randomUUID().toString(), "333", "33333", false),
                new User(UUID.randomUUID().toString(),UUID.randomUUID().toString(), "444", "44444", false),
                new User(UUID.randomUUID().toString(),UUID.randomUUID().toString(), "555", "55555", false)
        ).collect(Collectors.toList());
    }

    @RequestMapping(value="/user", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser() {

        return new User("userId", "photoId", "dominika", "opoka", false);
    }
}
