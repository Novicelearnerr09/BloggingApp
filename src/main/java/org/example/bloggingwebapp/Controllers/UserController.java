package org.example.bloggingwebapp.Controllers;

import org.example.bloggingwebapp.Entities.User;
import org.example.bloggingwebapp.Payloads.ApiResponse;
import org.example.bloggingwebapp.Payloads.UserDto;
import org.example.bloggingwebapp.Services.UserService;
import org.example.bloggingwebapp.implementation.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    //post - create user
  /*
    @Autowired
    UserImpl userImpl;
@PostMapping("/create")
    public String createUser(User user)
{
    UserDto userDto = this.UsertoDto(user);

     this.userImpl.createUser(userDto);
     return "User created";
}
*/
    @Autowired
    UserService userService;

    //POST-create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createUserDto = userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer userId) {

        UserDto userDtocreated = this.userService.updateUser(userDto, userId);
        return new ResponseEntity<>(userDtocreated, HttpStatus.OK);

    }

//    @DeleteMapping("/userId")
//    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer UId)
//    {
//        this.userService.deleteUser(UId);
//        return new ResponseEntity<ApiResponse>(new ApiResponse("message", true), HttpStatus.OK);
//
//    }

    @DeleteMapping("/userId")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        this.userService.deleteUser(userId);
    }



    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return  ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
public User DtotoUser(UserDto userDto)
{
    User user = new User();
    user.setId(userDto.getId());
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    user.setAbout(userDto.getAbout());

    return user;
}

public UserDto UsertoDto(User user)
{
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setName(user.getName());
    userDto.setEmail(user.getEmail());
    userDto.setPassword(user.getPassword());
    userDto.setAbout(user.getAbout());

    return userDto;
}


}
