package com.w6d5.w6d5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.w6d5.w6d5.enumerated.State;
import com.w6d5.w6d5.enumerated.Type;
import com.w6d5.w6d5.model.Device;

import com.w6d5.w6d5.model.User;

@Configuration
public class Beans {
	
	@Bean
	@Scope("prototype")
	public User user() {
		return User.builder()
				.fullName("Michael Scott")
				.username("Mike")
				.role("ADMIN")
				.password("111")
				.email("worldsbestboss@gg.com")
				.devices(null)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public User user2() {
		return User.builder()
				.fullName("Dwight Schrute")
				.username("ds")
				.role("USER")
				.password("222")
				.email("assistente@gg.com")
				.devices(null)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Device pc() {
		return Device.builder()
				.type(Type.PC)
				.state(State.AVAILABLE)
				.build();
	}
	@Bean
	@Scope("prototype")
	public Device smarthphone() {
		return Device.builder()
				.type(Type.SMARTPHONE)
				.state(State.AVAILABLE)
				.build();
	}
	@Bean
	@Scope("prototype")
	public Device tablet() {
		return Device.builder()
				.type(Type.TABLET)
				.state(State.AVAILABLE)
				.build();
	}

}
