package com.routing4you.littlenanny.impl;

import com.routing4you.littlenanny.Configuration;

import javax.inject.Named;
import java.util.regex.Pattern;


/**
 * Litte Nanny Apple Store-Resolver.
 */
@Named
public class AppleStoreUrlResolver implements UrlResolver {

	/**
	 * URL zum Appstore.
	 */
	private final String appstoreUrl;

	/**
	 * Pattern des Useragents.
	 */
	private Pattern uaPattern = Pattern.compile(".*(iphone|ipad|ipod).*", Pattern.CASE_INSENSITIVE);

	/**
	 * Constructor.
	 */
	public AppleStoreUrlResolver() {
		this.appstoreUrl = Configuration.getAppleAppstoreUrl();
	}


	/**
	 * null oder die URL.
	 *
	 * @param criteria criteria.
	 * @return null oder die url
	 */
	public String determineUrl(DeviceCriteria criteria) {
		String ua = criteria.getUseragent();
		if(ua != null && uaPattern.matcher(ua).matches()) {
			return appstoreUrl;
		}
		return null;
	}


}
