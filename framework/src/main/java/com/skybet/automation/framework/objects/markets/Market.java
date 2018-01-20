package com.skybet.automation.framework.objects.markets;

public class Market {

	private int marketId;
	private int eventId;
	private String name;
	private int displayOrder;
	private String type;
	private Status status = null;
	private Liabilities liabilities = null;
	private boolean spAvail;
	
	public int getMarketId() {
		return marketId;
	}
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Liabilities getLiabilities() {
		return liabilities;
	}
	public void setLiabilities(Liabilities liabilities) {
		this.liabilities = liabilities;
	}
	public boolean isSpAvail() {
		return spAvail;
	}
	public void setSpAvail(boolean spAvail) {
		this.spAvail = spAvail;
	}
	
}
