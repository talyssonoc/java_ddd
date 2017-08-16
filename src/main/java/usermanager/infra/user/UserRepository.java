package usermanager.infra.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import usermanager.domain.user.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
