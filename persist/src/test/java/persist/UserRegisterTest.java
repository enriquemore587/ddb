package persist;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.persist.enums.StatusUsers;
import com.persist.service.UserService;
import com.persist.util.HibernateUtil;

@RunWith(value = Parameterized.class)
public class UserRegisterTest {

	public Session session;
	private String userName, password;
	private Long typeUserId, profileId, consultingRoomsId;
	private Integer level;

	public UserRegisterTest(String userName, String password, Long typeUserId, Long profileId, Long consultingRoomsId,
			Integer level) {
		this.userName = userName;
		this.password = password;
		this.typeUserId = typeUserId;
		this.profileId = profileId;
		this.consultingRoomsId = consultingRoomsId;
		this.level = level;
	}

	@Parameters
	public static Iterable<Object[]> getData() {
		return Arrays.asList(new Object[][] { { "jo1se.ambriz1@atreva.mx", "123", 6l, 9l, 1l, 1 } });
	}

	@Before
	public void openSession() {
		this.session = HibernateUtil.getSessionfactory().openSession();
	}

	@After
	public void closeSession() {
		this.session.close();
	}

	@Test
	public void registerUser() {
		UserService userService = new UserService(this.session);
		String respuesta = userService.registerUser(this.userName, this.password, this.typeUserId, this.profileId,
				this.consultingRoomsId, this.level);
		assertEquals("NO SE GUARDO", StatusUsers._SUCCESS.getDescripcion(), respuesta);
	}

}
