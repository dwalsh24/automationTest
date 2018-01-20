package com.skybet.automation.framework.objects.events;

import java.util.*;

public class Event {

	private int eventId;
	private String name;
	private int displayOrder;
	private String sort;
	private int linkedEventId;
	private int classId;
	private String className;
	private int typeId;
	private String typeName;
	private int LinkedEventTypeId;
	private String startTime;
	private Scores scores = null;
	private List<Competitor> competitors = null;
	private Status status = null;
	private int boostCount;
	private int superBoostCount;
	
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
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getLinkedEventId() {
		return linkedEventId;
	}
	public void setLinkedEventId(int linkedEventId) {
		this.linkedEventId = linkedEventId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getLinkedEventTypeId() {
		return LinkedEventTypeId;
	}
	public void setLinkedEventTypeId(int linkedEventTypeId) {
		LinkedEventTypeId = linkedEventTypeId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Scores getScores() {
		return scores;
	}
	public void setScores(Scores scores) {
		this.scores = scores;
	}
	public List<Competitor> getCompetitors() {
		return competitors;
	}
	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getBoostCount() {
		return boostCount;
	}
	public void setBoostCount(int boostCount) {
		this.boostCount = boostCount;
	}
	public int getSuperBoostCount() {
		return superBoostCount;
	}
	public void setSuperBoostCount(int superBoostCount) {
		this.superBoostCount = superBoostCount;
	}

	
	
	
}
