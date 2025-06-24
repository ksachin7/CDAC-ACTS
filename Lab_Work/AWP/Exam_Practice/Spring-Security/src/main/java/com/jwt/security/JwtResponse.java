package com.jwt.security;


public class JwtResponse {
    private String jwtToken;
    private String username;
    private String roleName;
    private Long userId;  // Add userId to the response

    public JwtResponse(String jwtToken, String username, String roleName, Long userId) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.roleName = roleName;
        this.userId = userId;
    }

    // Getters and setters
    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

