package com.manojkk.learning.cardweb.dto;

import java.util.List;

public class UserCardObject {
	private String username;
	private List<Card> cards;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the cards
	 */
	public List<Card> getCards() {
		return cards;
	}
	/**
	 * @param cards the cards to set
	 */
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
}
