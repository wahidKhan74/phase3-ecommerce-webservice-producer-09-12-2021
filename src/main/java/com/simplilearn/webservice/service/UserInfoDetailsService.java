package com.simplilearn.webservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.simplilearn.webservice.entity.User;
import com.simplilearn.webservice.entity.UserInfoDetails;
import com.simplilearn.webservice.repository.UserRepository;

@Service
public class UserInfoDetailsService  implements UserDetailsService{

	@Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(UserInfoDetails::new).get();
    }
}
