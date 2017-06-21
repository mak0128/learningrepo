package com.manojkk.learning.cardweb.dto;

import java.util.Date;

public class Card {
	private String cardNo;
	private String cardType;
	private Date expiration;
	private Integer securityCode;
	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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
	/**
	 * @return the securityCode
	 */
	public Integer getSecurityCode() {
		return securityCode;
	}
	/**
	 * @param securityCode the securityCode to set
	 */
	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}
	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
