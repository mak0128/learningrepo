package com.manojkk.learning.cardweb.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Card_Details")
public class CardDetail {
	@Id
	@Column(name="card_no")
	private String cardNo;
	
	
	@Column(name="card_typ")
	private String cardType;
	@Column(name="card_exp")
	private Date expiration;
	@Column(name="sec_cd")
	private Integer securityCode;
	
	@ManyToOne(optional=false)
    @JoinColumn(name="card_no", insertable=false, updatable=false)
	private UserCards userCards;
	
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * @return the expiration
	 */
	public Date getExpiration() {
		return expiration;
	}
	/**
	 * @param expiration the expiration to set
	 */
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public Integer getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}
	/**
	 * @return the userCards
	 */
	public UserCards getUserCards() {
		return userCards;
	}
	/**
	 * @param userCards the userCards to set
	 */
	public void setUserCards(UserCards userCards) {
		this.userCards = userCards;
	}
	
}
