package com.skybet.automation.framework.objects.markets.updates;

import com.skybet.automation.framework.objects.markets.Status;

public class Data {

	private int eventId;
	private int marketId;
	private Status status;
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getMarketId() {
		return marketId;
	}
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
