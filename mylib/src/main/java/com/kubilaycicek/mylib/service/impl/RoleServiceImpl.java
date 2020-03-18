package com.kubilaycicek.mylib.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.kubilaycicek.mylib.repository.RoleRepository;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl {

	private RoleRepository roleRepository;
}
