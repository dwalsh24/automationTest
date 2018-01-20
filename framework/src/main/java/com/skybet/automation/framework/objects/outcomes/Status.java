package com.skybet.automation.framework.objects.outcomes;

public class Status {

	private boolean active;
	private boolean resulted;
	private boolean cashoutable;
	private boolean displayable;
	private boolean suspended;
	private String result;
	
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
