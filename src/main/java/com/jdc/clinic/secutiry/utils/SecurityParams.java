package com.jdc.clinic.secutiry.utils;

public class SecurityParams {

	public static final String JWT_HEADER_NAME = "Authorization";
	public static final String JWT_SECRET = "secret";
	public static final long JWT_EXPIRATION_TIME = 24 * 3600;
	public static final String JWT_HEADER_PREFIX = "Bearer";

}
