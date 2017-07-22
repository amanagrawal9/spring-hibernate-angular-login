package com.flikon.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flikon.entity.User;
import com.flikon.repository.RoleRepository;
import com.flikon.repository.UserRepository;
import com.flikon.wrapper.UserInfo;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SalesforceService salesforceService;

    public JSONObject saveUser(UserInfo userInfo) {
    	JSONObject response = salesforceService.createContact(userInfo);
    	
    	if(response != null && "success".equals(response.getString("Response Status"))) {
    		userRepository.save(adaptUserInfoToUser(userInfo));
    	}
    	return response;
    }

	public User updateUser(UserInfo userInfo) {
		User user = getUserByEmail(userInfo.getEmail());
		user.setFirstName(userInfo.getFirstName());
		user.setLastName(userInfo.getLastName());
		user.setContactNo(userInfo.getContactNo());
		user = userRepository.save(user);
		return user;
	}

    public User getUserByEmail(String email) {
		return userRepository.findByEmailId(email);
    }
    
    private User adaptUserInfoToUser(UserInfo info) {
    	
    	User user = new User();
    	user.setFirstName(info.getFirstName());
    	user.setLastName(info.getLastName());
    	user.setEmailId(info.getEmail());
	    if(info.getPassword() != null){
		    user.setPassword(bCryptPasswordEncoder.encode(info.getPassword()));
	    }
    	user.setContactNo(info.getContactNo());
    	return user;
    }

	public UserInfo adaptUserToUserInfo(User user) {
		UserInfo userInfo = new UserInfo(user.getEmailId(), user.getFirstName(), user.getLastName(), user.getContactNo(), "", "", "");
		return userInfo;
	}
}
