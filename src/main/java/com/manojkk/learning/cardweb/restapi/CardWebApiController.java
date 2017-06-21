package com.manojkk.learning.cardweb.restapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manojkk.learning.cardweb.dto.Card;
import com.manojkk.learning.cardweb.dto.UserDO;
import com.manojkk.learning.cardweb.dto.UserCardObject;
import com.manojkk.learning.cardweb.jpa.entity.UserCards;
import com.manojkk.learning.cardweb.jpa.repos.UserCardRepository;
import com.manojkk.learning.cardweb.restapi.exception.NoResourceFoundException;

@RestController
@RequestMapping("/cardapp/restapi")
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableResourceServer
public class CardWebApiController {
	private final static Logger logger = Logger.getLogger(CardWebApiController.class.getName());
	
	@Autowired
	private UserCardRepository userCardRepository;
	
	
	@PreAuthorize("hasAnyAuthority('READ_ROLE') or hasAnyAuthority('RW_ROLE')")
	@RequestMapping(method=RequestMethod.GET, value="/users")
	public List<UserDO> getUsers() {
		List<UserCards> userCards = userCardRepository.findAll();
		
		List<UserDO> users = new ArrayList<UserDO>();
		for (UserCards userCard : userCards) {
			UserDO user = new UserDO();
			user.setId(userCard.getId());
			user.setUsername(userCard.getUsername());
			users.add(user);
		}
		return users;
	}
	
	@PreAuthorize("hasAnyAuthority('RW_ROLE')")
	@RequestMapping(method=RequestMethod.GET, value="/{username}")
	public UserCardObject getUserCards(@PathVariable String username) {
		List<Object[]> userCards = userCardRepository.findByUsername(username);
		if (userCards == null || userCards.isEmpty()) {
			String errorMessage = String.format("User '%s' not found.", username);
			logger.info(errorMessage);
			throw new NoResourceFoundException(errorMessage);
		}
		UserCardObject userCardObject = new UserCardObject();
		userCardObject.setUsername(username);
		List<Card> cards = new ArrayList<Card>();
		for (Object[] cardDetail : userCards) {
			Card card = new Card();
			card.setCardNo((String) cardDetail[0]);
			card.setCardType((String) cardDetail[1]);
			card.setExpiration((Date) cardDetail[2]);
			card.setSecurityCode((Integer) cardDetail[3]);
			cards.add(card);
		}
		userCardObject.setCards(cards);
		return userCardObject;
	}
	
}
