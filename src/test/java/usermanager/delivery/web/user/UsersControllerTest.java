package usermanager.delivery.web.user;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import usermanager.app.user.GetAllUsers;
import usermanager.domain.user.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private GetAllUsers getAllUsers;

  @Test
  public void testIndex() throws Exception {
    ArrayList<User> users = new ArrayList<>();
    User user = new User();
    user.setId(123);
    user.setName("Talysson");
    users.add(user);

    given(getAllUsers.call()).willReturn(users);

    mvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$[0].id", is(123)))
      .andExpect(jsonPath("$[0].name", is("Talysson")));
  }
}
