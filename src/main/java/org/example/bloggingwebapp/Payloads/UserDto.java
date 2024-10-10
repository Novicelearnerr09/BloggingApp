package org.example.bloggingwebapp.Payloads;


import lombok.Getter;
import lombok.Setter;
import org.example.bloggingwebapp.Entities.User;

@Getter
@Setter
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private String about;


}
