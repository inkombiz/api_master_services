package com.inkombizz.master.security;

public class SecurityConstants {
	public static final String SECRET = "Inkombizz";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	//24 * 60 * 60 * 1000 = 864_000_000 = 1 hari
	
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
//	public static final String SIGN_UP_URL = "/v1/users/";
}
