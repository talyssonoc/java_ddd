package usermanager.app.user;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import usermanager.domain.user.User;
import usermanager.infra.user.UserRepository;

@Component
public class CreateUser {
  private UserRepository repository;

  @Autowired
  public CreateUser(UserRepository repository) {
    this.repository = repository;
  }

  public User call(String name) {
    User user = new User();
    user.setName(name);

    return repository.save(user);
  }
}
