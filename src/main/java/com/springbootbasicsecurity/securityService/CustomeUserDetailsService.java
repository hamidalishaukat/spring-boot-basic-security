package com.springbootbasicsecurity.securityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootbasicsecurity.repository.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//without H2
		 //User user = new User();
		 //if (!username.startsWith("hamid")) {
				//throw new UserNotFoundException();
			//}
		 //user.setUsername("hamid");
		 //user.setPassword("$2a$10$0hM/SICQjhLWBmYvDuoQkeb89lDcCIfzgZlX83If5zeivtUotpDRG");
		return userRepository.findByUsername(username);
	}

}
