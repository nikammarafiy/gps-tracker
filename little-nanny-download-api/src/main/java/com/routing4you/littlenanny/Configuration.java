package com.routing4you.littlenanny;

/**
 * Little Nanny GPS Tracker configuration.
 * Little Nanny is new type of Application to keep parents and their young children in touch.
 * The idea is to reuse any old Smartphone (Android or iOS) as a high precision tracking device.
 * After speaking with other parents, it was clear that there was a need for a really reliable App
 * to help give children the freedom they need to explore and discover, while staying in touch
 * with those who matter most. Little Nanny has a simple mission – to help kids be kids again,
 * while giving parents an amazing new window into their children’s lives.
 */
public class Configuration {


	public static String getFallbackUrl() {
		return "http://www.little-nanny.com/download.html";
	}

	public static String getGooglePlayUrl() {
		return "https://play.google.com/store/apps/details?id=com.pocketnanny.pnparent";
	}

	public static String getAppleAppstoreUrl() {
		return "https://itunes.apple.com/us/app/little-nanny-parent/id689321712?mt=8";
	}
}
