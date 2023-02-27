package com.marcob_w7_d5.Progetto_settimanale_7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.marcob_w7_d5.Progetto_settimanale_7.models.Control;
import com.marcob_w7_d5.Progetto_settimanale_7.models.SmokeSystem;

@Configuration
public class Beans {
	
	@Bean
	public Control control1() {
		return Control.builder()
			.controlName("Città italiane")
			.sonde(null)
			.build();
	}
	
	@Bean
	public SmokeSystem sys1() {
	    return SmokeSystem.builder()
	            .countryName("Bologna")
	            .latitudine(1200)
	            .longitudine(3000)
	            .smoke(0)
	            .build();
	}
	@Bean
	public SmokeSystem sys2() {
	    return SmokeSystem.builder()
	            .countryName("Palermo")
	            .latitudine(1260)
	            .longitudine(3100)
	            .smoke(0)
	            .build();
	}
	@Bean
	public SmokeSystem sys3() {
	    return SmokeSystem.builder()
	            .countryName("Udine")
	            .latitudine(1250)
	            .longitudine(3020)
	            .smoke(0)
	            .build();
	}
	@Bean
	public SmokeSystem sys4() {
	    return SmokeSystem.builder()
	            .countryName("Cagliari")
	            .latitudine(1400)
	            .longitudine(2900)
	            .smoke(0)
	            .build();
	}
	
	@Bean
	public SmokeSystem sys5() {
	    return SmokeSystem.builder()
	            .countryName("Roma")
	            .latitudine(1475)
	            .longitudine(2947)
	            .smoke(0)
	            .build();
	}
	
}
