package com.ly.common.gameutil.im;

/**
 * 小游戏派彩金额
 */
public class KagaBonusPick {
	/*"playerId": "SW35923456BC",
    "transactionId": "bde0e21a05874d0e89d78a3a951fe72a",
    "gameName": "StockedBar",
    "pickDate": "2018-09-23 07:55:01.787",
    "currency": "CNY",
    "denomination": 0.2,
    "cashWon": 1040,
    "creditsWon": 52*/
    private String playerId;
	private String transactionId;
	private String gameName;
	private String pickDate;
	private String currency;
	private Double denomination;
	private Long cashWon;
	private Long creditsWon;
	
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getPickDate() {
		return pickDate;
	}
	public void setPickDate(String pickDate) {
		this.pickDate = pickDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getDenomination() {
		return denomination;
	}
	public void setDenomination(Double denomination) {
		this.denomination = denomination;
	}
	public Long getCashWon() {
		return cashWon;
	}
	public void setCashWon(Long cashWon) {
		this.cashWon = cashWon;
	}
	public Long getCreditsWon() {
		return creditsWon;
	}
	public void setCreditsWon(Long creditsWon) {
		this.creditsWon = creditsWon;
	}
	
	@Override
	public String toString() {
		return "KagaBonusPick [playerId=" + playerId + ", transactionId=" + transactionId + ", gameName=" + gameName
				+ ", pickDate=" + pickDate + ", currency=" + currency + ", denomination=" + denomination + ", cashWon="
				+ cashWon + ", creditsWon=" + creditsWon + "]";
	}
}
