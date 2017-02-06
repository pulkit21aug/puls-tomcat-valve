/**
 * Sample valve
 */
package com.puls.auth.tomcat;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.*;
import org.apache.catalina.*;

/**
 * @author Pulkit.Saxena
 *
 */
public final class SamplePulsTomcatValve extends ValveBase {

	/**
	 * The descriptive information related to this implementation.
	 */
	private static final String info = "SamplePulsTomcatValve";

	/**
	 * Return descriptive information about this Valve implementation.
	 */
	public String getInfo() {
		return (info);
	}

	@Override
	public void invoke(Request request, Response response) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String queryParam = request.getQueryString();
		String pathInfo = request.getPathInfo();

		// parse cookies
		Cookie[] cookies = request.getCookies();
		for (Cookie cok : cookies) {
			System.out.println(cok.getName());
		}

		if (pathInfo != null && pathInfo.contains("/v1/user/test")) {
			System.out.println("SamplePulsTomcatValve invoked if path");

			// code to read body
			BufferedReader reader = request.getReader();

			// block the tomcat call
			System.out.println("BLOCKED THE HTTP Request-Not allowed to update");
			throw new IOException("BLOCKED THE HTTP Request-Not allowed to update");

		} else {
			System.out.println("SamplePulsTomcatValve do nothing else ");
			getNext().invoke(request, response);
		}

		System.out.println("SamplePulsTomcatValve complete ");
		getNext().invoke(request, response);
	}

}
