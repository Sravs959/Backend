package com.lnt.service;

import java.util.List;

import com.lnt.domain.UserDetails;

public interface UserDetailsService {

	List<UserDetails> getAllUserService();

	void addUserService(UserDetails u);

	UserDetails searchUserByIdService(int id);

	void updateUserDetailsService(UserDetails u, int id);

}
