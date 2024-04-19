package com.example.diary_bmk.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddUserRequest {
    private String email;
    private String password;
}
