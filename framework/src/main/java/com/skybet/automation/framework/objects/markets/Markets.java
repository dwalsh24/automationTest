package com.skybet.automation.framework.objects.markets;

import java.util.*;

public class Markets {

	private int marketId;
	private int eventId;
	private String name;
	private int displayOrder;
	private String type;
	private Map<String, Boolean> status = new HashMap<String, Boolean>();
	private Map<String, Integer> liabilities = new HashMap<String, Integer>();
	
}
