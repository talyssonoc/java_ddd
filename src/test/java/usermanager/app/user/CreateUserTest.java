package usermanager.app.user;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.ArgumentCaptor;

import usermanager.app.user.CreateUser;
import usermanager.infra.user.UserRepository;
import usermanager.domain.user.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateUserTest {

  @MockBean
  private UserRepository userRepository;

  @Test
  public void testCall() throws Exception {
    User user = new User();
    user.setId(123);
    user.setName("Talysson");

    ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);

    given(
      userRepository.save(argument.capture())
    ).willReturn(user);

    CreateUser command = new CreateUser(userRepository);

    User returnedUser = command.call("Talysson");

    assertThat(argument.getValue().getName(), is("Talysson"));
    assertThat(returnedUser.getName(), is("Talysson"));
    assertThat(returnedUser.getId(), is(123));
  }
}
