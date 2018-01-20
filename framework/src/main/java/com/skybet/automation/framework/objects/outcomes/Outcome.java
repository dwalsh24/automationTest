package com.skybet.automation.framework.objects.outcomes;

public class Outcome {

	private int outcomeId;
	private int marketId;
	private int eventId;
	private String name;
	private int displayOrder;
	private Result result = null;
	private int linkedOutcomeId;
	private Price price = null;
	private Status status = null;
	
	public int getOutcomeId() {
		return outcomeId;
	}
	public void setOutcomeId(int outcomeId) {
		this.outcomeId = outcomeId;
	}
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
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public int getLinkedOutcomeId() {
		return linkedOutcomeId;
	}
	public void setLinkedOutcomeId(int linkedOutcomeId) {
		this.linkedOutcomeId = linkedOutcomeId;
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
