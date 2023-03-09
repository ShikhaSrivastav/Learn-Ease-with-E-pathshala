package com.app.services;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDtoToEntitiys;
import com.app.entity.User;
import com.app.repository.UserDao;

@Transactional
@Service
public class AdminServices {
@Autowired
private UserDao userdao;
@Autowired
private UserDtoToEntitiys userdtos;
//public Map<String, Object> deleteUser(int id) {
//	// TODO Auto-generated method stub
//	return null;
//}

//-----------------------UserFunctionailty---------------------------------------------------------------//

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
