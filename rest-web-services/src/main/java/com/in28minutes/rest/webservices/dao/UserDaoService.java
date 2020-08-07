package com.in28minutes.rest.webservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.model.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;

	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Apple", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	//Here, the method does not accept any parameters. We are asking to return the list of all users. .
	public List<User> findAll() {
		return users;
	}

	// if the user passes id as null. set an id to the user and increase the users
	// count.
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findByOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == null) {
				iterator.remove();
				return user;
			}
		}

		return null;
	}
}