package com.w6d5.w6d5;

import java.util.HashSet;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.w6d5.w6d5.config.Beans;
import com.w6d5.w6d5.enumerated.State;
import com.w6d5.w6d5.model.Device;
import com.w6d5.w6d5.model.User;
import com.w6d5.w6d5.service.DeviceService;
import com.w6d5.w6d5.service.UserService;

@SpringBootApplication
public class W6d5Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(W6d5Application.class, args);
	}
	@Autowired
	private UserService us;
	@Autowired
	private DeviceService ds;
	
	@Override
	public void run(String... args) throws Exception {
		int x=0;
		if(x==1) {
		insertDb();
		}
	}
	public void insertDb() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		User u1 = (User)ctx.getBean("user");
		User u2 = (User)ctx.getBean("user2");
		us.save(u1);
		us.save(u2);
	
	
		((AnnotationConfigApplicationContext)ctx).close();
	}

}
