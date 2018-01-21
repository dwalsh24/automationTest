package com.skybet.automation.framework.objects.markets;

import java.util.*;

public class Markets {

	private List<Market> markets = null;

	public Market getMarketByMarketId(int marketId) {
		Market market = null;
		for (Market x : markets) {
			if (x.getEventId() == marketId) {
				market = x;
				break;
			}
		}
		return market;
	}

	public List<Market> getMarkets() {
		return markets;
	}

	public void setMarkets(List<Market> markets) {
		this.markets = markets;
	}

}
