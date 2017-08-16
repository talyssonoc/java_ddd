package usermanager.delivery.web.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import usermanager.app.user.GetAllUsers;
import usermanager.app.user.CreateUser;
import usermanager.app.user.GetUser;
import usermanager.domain.user.User;

@RestController
@RequestMapping("/users")
public class UsersController {
  @Autowired
  private GetAllUsers getAllUsers;

  @Autowired
  private CreateUser createUser;

  @Autowired
  private GetUser getUser;

  @RequestMapping(method=RequestMethod.GET)
  public @ResponseBody Iterable<User> index() {
    Iterable<User> users = getAllUsers.call();

    return users;
  }

  @RequestMapping(method=RequestMethod.POST)
  public @ResponseBody User create(@RequestParam String name) {
    User user = createUser.call(name);

    return user;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
  public @ResponseBody User show(@PathVariable Integer userId) {
    User user = getUser.call(userId);

    return user;
  }
}
