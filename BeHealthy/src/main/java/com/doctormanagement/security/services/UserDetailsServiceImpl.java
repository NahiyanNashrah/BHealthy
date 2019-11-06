package com.doctormanagement.security.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doctormanagement.model.User;
import com.doctormanagement.repository.UserRepository;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    UserRepository userRepository;
 
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String phonenumber)
            throws UsernameNotFoundException {
      
        User user = userRepository.findByPhonenumber(phonenumber)
                  .orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> phonenumber or email : " + phonenumber)
        );
 
        return UserPrinciple.build(user);
    }
}