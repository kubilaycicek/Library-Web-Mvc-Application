package com.kubilaycicek.mylib.dto;


import com.kubilaycicek.mylib.entity.Role;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
	private long id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String phone;
	private boolean isActive;
	private RoleDto roleDto;
}
