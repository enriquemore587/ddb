package com.persist.service;

import java.util.List;

import org.hibernate.Session;

import com.persist.dao.UserDao;
import com.persist.dao.UserDaoImpl;
import com.persist.domain.ConsultingRooms;
import com.persist.domain.Profile;
import com.persist.domain.TypeUser;
import com.persist.domain.User;
import com.persist.enums.StatusUsers;

/**
 * @author Jose Enrique Vergara
 *
 */
public class UserService implements UserDao {

	private UserDao userDao;
	private TypeUserService typeUserService;
	private ProfileService profileService;
	private ConsultingRoomsService consultingRoomsService;

	public UserService(Session session) {
		this.userDao = new UserDaoImpl(session);
		this.typeUserService = new TypeUserService(session);
		this.profileService = new ProfileService(session);
		this.consultingRoomsService = new ConsultingRoomsService(session);
	}

	public void save(User user) {
		this.userDao.save(user);

	}

	public List<User> findAll() {
		return this.userDao.findAll();
	}

	public User findById(Long id) {
		return this.userDao.findById(id);
	}

	public void closeSession() {
		this.userDao.closeSession();
	}

	public User findByUserName(String user_name) {
		return this.userDao.findByUserName(user_name);
	}

	public String registerUser(String userName, String password, Long typeUserId, Long profileId,
			Long consultingRoomsId) {
		String respuesta = "";

		User user = this.findByUserName(userName);

		if (user != null) {
			respuesta = StatusUsers._THERE_IS_ALREADY_A_USER.getDescripcion();
		} else {
			user = new User(userName, password);
			TypeUser typeUser = this.typeUserService.findById(typeUserId);
			if (typeUser == null) {
				respuesta = StatusUsers._TYPE_USER_NOT_FOUND.getDescripcion();
			} else {
				user.setTypeUser(typeUser);
				Profile profile = this.profileService.findById(profileId);
				if (profile == null) {
					respuesta = StatusUsers._PROFILE_NOT_FOUND.getDescripcion();
				} else {
					user.setProfile(profile);
					ConsultingRooms consultingRooms = consultingRoomsService.findById(consultingRoomsId);
					if (consultingRooms == null) {
						respuesta = StatusUsers._CONSULTING_ROOMS_NOT_FOUND.getDescripcion();
					} else {
						user.setConsultingRooms(consultingRooms);
						this.userDao.save(user);
						respuesta = StatusUsers._SUCCESS.getDescripcion();
					}
				}
			}
		}
		return respuesta;
	}

}
