package com.guanghui.springbootreact.model;

import lombok.Data;

/**
 * keep credentials for authentication, not need to save in db
 * As @RequestBody in AuthController
 */
@Data
public class AccountCredentials {
    private String username;
    private String password;
}
