package com.skybet.automation.framework.objects.markets;

public class Status {

	private boolean active;
	private boolean resulted;
	private boolean cashoutable;
	private boolean displayable;
	private boolean suspended;
	private boolean noExtraTime;
	private boolean live;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isResulted() {
		return resulted;
	}
	public void setResulted(boolean resulted) {
		this.resulted = resulted;
	}
	public boolean isCashoutable() {
		return cashoutable;
	}
	public void setCashoutable(boolean cashoutable) {
		this.cashoutable = cashoutable;
	}
	public boolean isDisplayable() {
		return displayable;
	}
	public void setDisplayable(boolean displayable) {
		this.displayable = displayable;
	}
	public boolean isSuspended() {
		return suspended;
	}
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	public boolean isNoExtraTime() {
		return noExtraTime;
	}
	public void setNoExtraTime(boolean noExtraTime) {
		this.noExtraTime = noExtraTime;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
}
