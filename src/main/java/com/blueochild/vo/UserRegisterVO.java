package com.blueochild.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserRegisterVO {
    private String email;
    private String name;
    private String phone;

    @Override
    public String toString(){
        return String.format(
                "UserRegisterVOI[email='%s', name='%s', phone='%s']",
                this.email, this.name, this.phone
        );
    }
}
