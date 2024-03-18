package com.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String phone;
    private String email;
    private String password;
    private int userStatus;
}
