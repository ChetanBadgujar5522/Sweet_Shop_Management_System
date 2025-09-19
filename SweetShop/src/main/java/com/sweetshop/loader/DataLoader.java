package com.sweetshop.loader;

import com.sweetshop.model.Sweet;
import com.sweetshop.model.User;
import com.sweetshop.repository.SweetRepository;
import com.sweetshop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private SweetRepository srepo;
	@Autowired
	private UserRepository urepo;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public void run(String... args) throws Exception {
		if (urepo.count() == 0) {
			User admin = new User(null, "admin", encoder.encode("adminpass"), "ROLE_ADMIN");
			User user = new User(null, "user", encoder.encode("userpass"), "ROLE_USER");
			urepo.save(admin);
			urepo.save(user);
		}

		if (srepo.count() == 0) {
			srepo.save(new Sweet(null, "Gulab Jamun", "Indian", 40.0, 20));
			srepo.save(new Sweet(null, "Rasgulla", "Bengali", 30.0, 15));
			srepo.save(new Sweet(null, "Barfi", "Indian", 50.0, 10));
		}
	}
}
