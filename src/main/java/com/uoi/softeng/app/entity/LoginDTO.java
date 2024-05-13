package com.uoi.softeng.app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@RequiredArgsConstructor
public class LoginDTO {
    public String email;
    public String password;
}
