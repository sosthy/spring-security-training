package com.example.demo.security.constants;

public class JwtConstants {
    public static final String SECRET_KEY = "securesecuresecuresecuresecuresecuresecuresecuresecuresecure";
    public static final Long EXPIRATION_DAYS = 1L;
    public static final String CLAIM_AUTHORITIES = "authorities";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
}
