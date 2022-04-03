package com.lnt.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.domain.UserDetails;
import com.lnt.repository.UserDetailsDao;

@Transactional //It is used when you want certain methods to be executed in a transaction
@Service //It is one of @component annotation and it is used to indicate service mechanism 
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;
	
	

	@Override
	public List<UserDetails> getAllUserService() {
		// TODO Auto-generated method stub
		return userDetailsDao.searchAllUsers();
	}

	@Override
	public void addUserService(UserDetails u) {
		// TODO Auto-generated method stub
		userDetailsDao.addNewUser(u);

	}

	@Override
	public UserDetails searchUserByIdService(int id) {
		// TODO Auto-generated method stub
		UserDetails u= userDetailsDao.searchUserById(id);
		
		if(u==null)
		{
			//Exception msg
		}
		
		return u;
	}

	@Override
	public void updateUserDetailsService(UserDetails u, int id) {
		// TODO Auto-generated method stub
		userDetailsDao.updateUserDetails(u, id);
		
	}
	
	

}
