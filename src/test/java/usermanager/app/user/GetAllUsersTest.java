package usermanager.app.user;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import usermanager.app.user.GetAllUsers;
import usermanager.infra.user.UserRepository;
import usermanager.domain.user.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetAllUsersTest {

  @MockBean
  private UserRepository userRepository;

  @Test
  public void testCall() throws Exception {
    ArrayList<User> users = new ArrayList<>();
    User user = new User();
    user.setId(123);
    user.setName("Talysson");
    users.add(user);

    given(userRepository.findAll()).willReturn(users);

    GetAllUsers command = new GetAllUsers(userRepository);

    Iterable<User> returnedUsers = command.call();

    assertThat(returnedUsers, is(users));
  }
}
