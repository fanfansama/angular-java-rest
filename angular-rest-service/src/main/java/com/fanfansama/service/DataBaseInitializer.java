package com.fanfansama.service;

import com.fanfansama.dal.dao.NewsEntryDao;
import com.fanfansama.dal.dao.UserDao;
import com.fanfansama.dal.model.NewsEntry;
import com.fanfansama.dal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;



/**
 * Initialize the database with some test entries.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 */
@Component
public class DataBaseInitializer
{
	@Autowired
	private NewsEntryDao newsEntryDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;


	@PostConstruct
	public void initDataBase()
	{
		User userUser = new User("user", this.passwordEncoder.encode("user"));
		userUser.addRole("user");
		this.userDao.save(userUser);

		User adminUser = new User("admin", this.passwordEncoder.encode("admin"));
		adminUser.addRole("user");
		adminUser.addRole("admin");
		this.userDao.save(adminUser);

		long timestamp = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
		for (int i = 0; i < 10; i++) {
			NewsEntry newsEntry = new NewsEntry();
			newsEntry.setContent("This is example content " + i);
			newsEntry.setDate(new Date(timestamp));
			this.newsEntryDao.save(newsEntry);
			timestamp += 1000 * 60 * 60;
		}
	}

}
