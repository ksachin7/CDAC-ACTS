package com.jwt.dto;

import java.time.LocalDate;
import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private boolean isActive;
    private LocalDate roleExpiryDate;
    private Long roleId;  // Use this to associate a role by its ID, if needed
    private Set<Long> courseIds;  // Use this to associate courses by their IDs, if needed
    
    // No password here if you want to avoid sending it in responses.
    // If you need it for creation requests, add it below.
    private String password;  // Only include this for registration or password updates
}


