package com.solidtech.zuulapigatewayserver.security;

public class SecurityConstants {

    public static final String SECRET = "kahodan@solidtech.tech";
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static final String AUTHORITIES_KEY = "roles";
    public static final String SIGNING_KEY = "signingkey";
    public static final int TOKEN_VALIDITY = 18000;
}
