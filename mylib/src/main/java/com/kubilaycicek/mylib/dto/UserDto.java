package com.kubilaycicek.mylib.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class UserDto {
	private long id;
	private String name;
	private String surname;
	private String username;
	private String email;
	private String password;
	private String password2;
	private RoleDto roleDto;
}
