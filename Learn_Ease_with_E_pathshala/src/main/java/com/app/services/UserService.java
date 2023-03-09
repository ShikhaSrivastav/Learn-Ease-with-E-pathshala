package com.app.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.Credentials;
import com.app.dto.UserDTO;
import com.app.dto.UserDTOS;
import com.app.dto.UserDtoToEntitiy;
import com.app.dto.UserDtoToEntitiys;
import com.app.entity.User;
import com.app.repository.UserDao;



@Service
public class UserService {
	@Autowired
	private UserDao userdao;
	@Autowired
	private UserDtoToEntitiy converter;
	@Autowired
    private UserDtoToEntitiys convert;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	public UserDTO authenticate(Credentials cred) {
		User dbUser = userdao.findByEmail(cred.getEmail());
		String rawPassword = cred.getPassword();
		if(dbUser != null && passwordEncoder.matches(rawPassword, dbUser.getPassword())) {
			UserDTO result = converter.toUserDto(dbUser);
			result.setPassword("********");
			return result;
		}
		return null;
	}
//	public Map<String, Object> saveUser(UserDTO userDto) {
//		String rawPassword = userDto.getPassword();
//		String encPassword = passwordEncoder.encode(rawPassword);
//		userDto.setPassword(encPassword);
//		User user = converter.toUserEntity(userDto);
//		user = userdao.save(user);
//		return Collections.singletonMap("insertedId", user.getUser_id());
//	}
	
	public Map<String, Object> saveUser(UserDTOS userDto) {
		String rawPassword = userDto.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		userDto.setPassword(encPassword);
		User user = convert.toUserEntity(userDto);
		user = userdao.save(user);
		return Collections.singletonMap("insertedId", user.getId());
	}
//	public List<UserDTOS> findAllUser(){
//		List<User> userlist =userdao.findAll();
//		return userlist.stream()
//				.map(user -> converter.toUserDto(user))
//				.collect(Collectors.toList());
//	}
//	public UserDTOS findUserById(int userid) {
//		User user = userdao.findById(userid);
//		return converter.toUserDto(user);
//	}
	
	public List<User> findAllUser(){
		List<User> userList =userdao.findAll();
		return userList;

	}
	public UserDTO findUserById(int User_id) {
		User user = userdao.findById(User_id);
		return converter.toUserDto(user);
	}
	

public Map<String, Object> deleteUser(int id) {
	Optional<User> user = Optional.ofNullable(userdao.findById(id));
	 User finduser=user.orElse(null);
	if(userdao.existsById(id) && !(finduser.getRole().equals("admin"))) 
	{
		userdao.deleteById(id);
		return Collections.singletonMap("affectedRows", 1);
	}
	return Collections.singletonMap("affectedRows", 0);
}

	
	
}
