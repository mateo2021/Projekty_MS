package ovh.devnote.controller;

import java.security.Principal;

import ovh.devnote.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ovh.devnote.DAO.UserDao;


@RestController
public class HomeRestController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		if (userDao.findOneByUsername(user.getUsername()) != null) {
			throw new RuntimeException("Nazwa została zajeta");
		}
		user.setRole("USER");
		return new ResponseEntity<User>(userDao.save(user), HttpStatus.CREATED);
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
}
