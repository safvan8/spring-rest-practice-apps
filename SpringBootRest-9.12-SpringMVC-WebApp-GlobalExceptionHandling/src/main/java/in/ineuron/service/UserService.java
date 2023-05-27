package in.ineuron.service;

import org.springframework.stereotype.Service;

import in.ineuron.exceptionhandling.UserNotFoundException;
import in.ineuron.model.User;

@Service
public class UserService {
	
	public User findUserById(Integer userId)
	{
		// write logic to connect with DB retrive data
		if (userId == 3)
			return new User(3, "roboUser", "FGgfd%^34hGh");
		else 
			throw new UserNotFoundException("User with id:"+userId+"  is not available");
	}
}
