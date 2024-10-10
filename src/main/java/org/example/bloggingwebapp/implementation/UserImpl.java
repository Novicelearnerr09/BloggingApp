package org.example.bloggingwebapp.implementation;

import org.example.bloggingwebapp.Entities.User;
import org.example.bloggingwebapp.Exceptions.ResourceNotFoundException;
import org.example.bloggingwebapp.Payloads.UserDto;
import org.example.bloggingwebapp.Repositories.UserRepo;
import org.example.bloggingwebapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
       return this.UsertoDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id",userId));
//
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User savedUser = this.userRepo.save(user);
        return this.UsertoDto(savedUser);

    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id",userId));
        return this.UsertoDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
//        List<User> users=this.userRepository.findAll();
//        List<UserDto> userDtos=new ArrayList<>();
//        for(User user:users){
//            userDtos.add(this.UsertoDto(user));
//        }
//        return userDtos;
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user->this.UsertoDto(user)).collect(Collectors.toList());
        return userDtos;


    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id",userId));
        this.userRepo.delete(user);
    }

    //Conversion - userDto to user
    private User dtoToUser(UserDto userDto)
    {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;


    }

    //Conversion - user to userDto
    private  UserDto UsertoDto(User user)
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
