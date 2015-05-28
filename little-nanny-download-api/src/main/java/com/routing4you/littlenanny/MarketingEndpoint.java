package com.routing4you.littlenanny;


import com.routing4you.littlenanny.impl.AppleStoreUrlResolver;
import com.routing4you.littlenanny.impl.DeviceCriteria;
import com.routing4you.littlenanny.impl.GooglePlayStoreUrlResolver;
import com.routing4you.littlenanny.impl.UrlResolver;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Use this class a the entpont of your jersey server to allow users an automatic litte nanny gps tracker download.
 * Supports redirect to apple store, play store and website.
 */
@Path("m")
public class MarketingEndpoint {

	private static final java.util.logging.Logger LOG = java.util.logging.Logger
			.getLogger(MarketingEndpoint.class.getName());

	private final List<UrlResolver> redirects;

	/**
	 * Marketting.
	 */
	public MarketingEndpoint() {
		redirects = new ArrayList<>();
		redirects.add(new AppleStoreUrlResolver());
		redirects.add(new GooglePlayStoreUrlResolver());
	}


	/**
	 * Redircts to the download link.
	 *
	 * @param userAgent the user agent
	 * @return the reponse.
	 */
	@Path("d")
	@GET
	public Response redirectBarcode(@HeaderParam("user-agent") String userAgent) {
		String url = null;
		if(userAgent != null) {
			final DeviceCriteria criteria = new DeviceCriteria();
			criteria.setUseragent(userAgent);
			for (UrlResolver redirect : redirects) {
				url = redirect.determineUrl(criteria);
				if(url != null) {
					break;
				}
			}

		}
		if(url == null) {
			url = Configuration.getFallbackUrl();
		}

		URI uri = UriBuilder.fromUri(url).build();
		return Response.seeOther(uri).build();
	}


}
