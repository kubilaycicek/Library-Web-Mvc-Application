package com.kubilaycicek.mylib.service;

import java.util.List;

import com.kubilaycicek.mylib.entity.User;
import org.springframework.stereotype.Service;

import com.kubilaycicek.mylib.dto.UserDto;

@Service
public interface UserService {
	User findByUsername(String userName);
	UserDto addUser(UserDto userDto);
	UserDto updateUser(UserDto userDto);
	List<UserDto> getAllUser();
	UserDto getByUserID(long userID);
	boolean removeByUserID(long userID);
}
