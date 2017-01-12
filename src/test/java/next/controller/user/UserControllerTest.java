package next.controller.user;


import next.dao.UserDao;
import next.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by 강홍구 on 2017-01-09.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserController controller;

    @Test
    public void insert() throws Exception {
        User user = new User("test", "password", "name", "");
        controller.create(user);
        verify(userDao).insert(user);
    }

    @Test
    public void profile() throws Exception {
        when(userDao.findByUserId("test"))
                .thenReturn(new User("test", "password", "name", ""));
        ExtendedModelMap model = new ExtendedModelMap();
        controller.profile("test", model);

        User user = (User) model.get("user");
        System.out.println("User : " + user);
    }
}
