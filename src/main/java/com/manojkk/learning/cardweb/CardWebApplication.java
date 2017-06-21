package com.manojkk.learning.cardweb;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manojkk.learning.cardweb.jpa.repos.UserCardRepository;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableAutoConfiguration
public class CardWebApplication implements CommandLineRunner
{
	private final static Logger logger = Logger.getLogger(CardWebApplication.class.getName());
	
	@Autowired
	private UserCardRepository userCardRepository;
	
    public static void main( String[] args )
    {
        SpringApplication.run(CardWebApplication.class, args);

        
    }

	@Override
	public void run(String... arg0) throws Exception {
        System.out.println( "Hello World!" );

        List<Object[]> userCards = userCardRepository.findByUsername("manojkk");
        
        if (userCards == null) {
        	logger.info("User not found :manojkk");
        } 
	}
    
    
}
