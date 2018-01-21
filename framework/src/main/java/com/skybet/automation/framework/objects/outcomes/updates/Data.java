package com.skybet.automation.framework.objects.outcomes.updates;

import com.skybet.automation.framework.objects.outcomes.Price;
import com.skybet.automation.framework.objects.outcomes.Status;

public class Data {
	private int eventId;
	private int marketId;
	private int outcomeId;
	private Price price;
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
	public int getOutcomeId() {
		return outcomeId;
	}
	public void setOutcomeId(int outcomeId) {
		this.outcomeId = outcomeId;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
