package com.test.RestFulWebServices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int usercount = 3;

	static {
		users.add(new User(1, "Sam", new Date()));
		users.add(new User(2, "John", new Date()));
		users.add(new User(3, "Danny", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	/**
	 * @param user
	 * @return
	 */
	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++usercount);
		}
		users.add(user);
		return user;
	}

	/**
	 * @param id
	 * @return
	 */
	public User findOne(int id) {

		for (User user : users) {

			if (user.getId() == id) {

				return user;
			}

		}

		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> userIterator = users.iterator();
		while(userIterator.hasNext()) {
			User user = userIterator.next();
			if(user.getId() == id) {
				userIterator.remove();
				return user;
			}
		}
		return null;
	}
}
