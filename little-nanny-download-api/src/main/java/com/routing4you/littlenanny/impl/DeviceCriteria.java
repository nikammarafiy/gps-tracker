package com.routing4you.littlenanny.impl;

/**
 * Criteria.
 * 
 */
public class DeviceCriteria {
	/**
	 * User-Agent des Users. (Browser).
	 */
	private String useragent;



	public String getUseragent() {
		return useragent;
	}



	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}



	@Override
	public String toString() {
		return "User-Agent: " + useragent;
	}
}
