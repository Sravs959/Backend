package com.lnt.repository;

import java.util.List;

import com.lnt.domain.UserDetails;

public interface UserDetailsDao {

	List<UserDetails> searchAllUsers();

	UserDetails searchUserById(int id);

	void updateUserDetails(UserDetails u, int id);

	void addNewUser(UserDetails u);

}
