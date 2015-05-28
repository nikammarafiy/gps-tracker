package com.routing4you.littlenanny.impl;


/**
 * URL resolver.
 */
public interface UrlResolver {

	/**
	 * Gibt die URL zum jeweiligen Apppstore zurueck.
	 * 
	 * @param criteria
	 *            criteria.
	 * @return URL.
	 */
	String determineUrl(DeviceCriteria criteria);
}
