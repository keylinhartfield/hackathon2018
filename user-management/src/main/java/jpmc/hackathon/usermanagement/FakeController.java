package jpmc.hackathon.usermanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class FakeController {


    @GetMapping(path = "/list")
    public List<User> list() {
        return Stream.of(
                new User(UUID.randomUUID().toString(), "111", "11111"),
                new User(UUID.randomUUID().toString(), "222", "22222"),
                new User(UUID.randomUUID().toString(), "333", "33333"),
                new User(UUID.randomUUID().toString(), "444", "44444"),
                new User(UUID.randomUUID().toString(), "555", "55555")
        ).collect(Collectors.toList());
    }

}
