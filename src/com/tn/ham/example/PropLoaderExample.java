package com.tn.ham.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


/**
 *
 * @author Hamza
 */

@Configuration
@PropertySource("classpath:example.properties")
public class PropLoaderExample {
	 	@Autowired
	    private Environment env;
	    
	    @Bean(name="message_bean")
	    public String getMessageDeMeeting(){
	         return env.getProperty("message");
	    }
	    
	    @Bean(name="tel_bean")
	    public String getNumeroTel(){
	    	return env.getProperty("num_tel");
	    }
	    
	    @Bean(name="monSite")
	    public String getSite(){
	    	return env.getProperty("site");
	    }
	    
	    public static void main(String[] args) {
	        ApplicationContext context = new AnnotationConfigApplicationContext(PropLoaderExample.class);
	        
	        //chaine de caractéres
	        String msg=(String) context.getBean("message_bean");
	        //nombre
	        int x= Integer.parseInt((String) context.getBean("tel_bean"));
	       //chaine de caractéres
	        String url_site=(String) context.getBean("monSite");
	        
	        
	        System.out.println(msg);
	        System.out.println(x);   
	        System.out.println(url_site); 
	        
	    }
}
