package usermanager.app.user;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import usermanager.domain.user.User;
import usermanager.infra.user.UserRepository;

@Component
public class GetUser {
  private UserRepository repository;

  @Autowired
  public GetUser(UserRepository repository) {
    this.repository = repository;
  }

  public User call(Integer userId) {
    return repository.findOne(userId);
  }
}
