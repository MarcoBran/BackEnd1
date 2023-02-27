package com.marcob_w7_d5.Progetto_settimanale_7;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.marcob_w7_d5.Progetto_settimanale_7.config.Beans;
import com.marcob_w7_d5.Progetto_settimanale_7.models.Control;
import com.marcob_w7_d5.Progetto_settimanale_7.models.SmokeSystem;
import com.marcob_w7_d5.Progetto_settimanale_7.services.ControlService;
import com.marcob_w7_d5.Progetto_settimanale_7.services.SmokeSystemService;

@SpringBootApplication
public class ProgettoSettimanale7Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSettimanale7Application.class, args);
		
	}
	
	@Autowired
	private SmokeSystemService ss;
	@Autowired
	private ControlService cs;
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
	
	@Override
	   public void run(String... args) throws Exception {
        int x=1;
        if(x==1) {
        	populateDb();
        }
        ((AnnotationConfigApplicationContext)ctx).close();

    }
    public void populateDb() {
        Control c1=(Control) ctx.getBean("control1");
        SmokeSystem ss1=(SmokeSystem)ctx.getBean("sys1");
        SmokeSystem ss2=(SmokeSystem)ctx.getBean("sys2");
        SmokeSystem ss3=(SmokeSystem)ctx.getBean("sys3");
        SmokeSystem ss4=(SmokeSystem)ctx.getBean("sys4");
        c1.setSonde(new HashSet<>() {private static final long serialVersionUID = 1L;
        {
            add(ss1);
            add(ss2);
            add(ss3);
            add(ss4);
        }});
        cs.save(c1);
        ss.save(ss1);
        ss.save(ss2);
        ss.save(ss3);
        ss.save(ss4);
    }

}
