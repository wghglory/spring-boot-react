package com.guanghui.springbootreact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayload {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
