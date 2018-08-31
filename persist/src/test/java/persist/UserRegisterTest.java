package persist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.mysql.fabric.xmlrpc.base.Array;
import com.persist.domain.ConsultingRooms;
import com.persist.domain.Profile;
import com.persist.domain.TypeUser;
import com.persist.domain.User;
import com.persist.enums.StatusUsers;
import com.persist.service.CivilStatusService;
import com.persist.service.ConsultingRoomsService;
import com.persist.service.ProfileService;
import com.persist.service.TypeUserService;
import com.persist.service.UserService;
import com.persist.util.HibernateUtil;

@RunWith(value = Parameterized.class)
public class UserRegisterTest {

	public Session session;
	private String userName, password;
	private Long typeUserId, profileId, consultingRoomsId;

	public UserRegisterTest(String userName, String password, Long typeUserId, Long profileId, Long consultingRoomsId) {
		this.userName = userName;
		this.password = password;
		this.typeUserId = typeUserId;
		this.profileId = profileId;
		this.consultingRoomsId = consultingRoomsId;
	}

	@Parameters
	public static Iterable<Object[]> getData() {
		return Arrays.asList(new Object[][] { { "jose.ambriz1@atreva.mx", "123", 6l, 9l, 1l },
				{ "jose.ambriz@atreva.mx", "123", -6l, 9l, 1l }, { "jose.ambriz@atreva.mx", "123", 6l, -9l, 1l },
				{ "jose.ambriz@atreva.mx", "123", 6l, 9l, -1l }, { "jose.ambriz@atreva.mx", "123", 6l, 9l, 1l } });
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
				this.consultingRoomsId);
		assertEquals("NO SE GUARDO", StatusUsers._SUCCESS.getDescripcion(), respuesta);
	}

}
