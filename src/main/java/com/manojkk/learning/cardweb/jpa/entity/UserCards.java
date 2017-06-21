package com.manojkk.learning.cardweb.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User_Card_Details")
public class UserCards {
	@Id
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@OneToMany(mappedBy="userCards", targetEntity=CardDetail.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<CardDetail> cards;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<CardDetail> getCards() {
		return cards;
	}

	public void setCards(List<CardDetail> cards) {
		this.cards = cards;
	}

}
