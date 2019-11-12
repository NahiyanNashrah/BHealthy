package com.doctormanagement.controller;

import java.util.HashSet;
import java.util.Set;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctormanagement.message.request.LoginForm;
import com.doctormanagement.message.request.SignUpFormDoctor;
import com.doctormanagement.message.request.SignUpFormPatient;
import com.doctormanagement.message.response.JwtResponse;
import com.doctormanagement.model.Doctor;
import com.doctormanagement.model.Patient;
import com.doctormanagement.model.Role;
import com.doctormanagement.model.RoleName;
import com.doctormanagement.model.User;
import com.doctormanagement.repository.DoctorRepository;
import com.doctormanagement.repository.PatientRepository;
import com.doctormanagement.repository.RoleRepository;
import com.doctormanagement.repository.UserRepository;
import com.doctormanagement.security.jwt.JwtProvider;
 

 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
 
    @Autowired
    AuthenticationManager authenticationManager;
 
    @Autowired
    UserRepository userRepository;
 
    @Autowired
    RoleRepository roleRepository;
 
    @Autowired
    PasswordEncoder encoder;
 
    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    PatientRepository patientRepository;
    
    @Autowired
    DoctorRepository doctorRepository;
    
    
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getPhonenumber(),
                        loginRequest.getPassword()
                )
        );
 
        SecurityContextHolder.getContext().setAuthentication(authentication);
 
        return ResponseEntity.ok(jwtProvider.generateJwtToken(authentication));
    }
 
    
    
       
    
    
    @PostMapping("/signup_patient")
    public ResponseEntity<String> registerPatient( @RequestBody SignUpFormPatient signUpRequest) {
    	if(userRepository.existsByPhonenumber(signUpRequest.getPhonenumber())) {
            return new ResponseEntity<String>("Fail -> Phone Number is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
 
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
 
        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getPhonenumber(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
 
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
 
        
        user.setRoles(roles);
        userRepository.save(user);
 
    	Patient patient = new Patient(signUpRequest.getPhonenumber(),signUpRequest.getEmail(),user.getPassword(),signUpRequest.getWeight(),signUpRequest.getName(),signUpRequest.getBloodgroup(),signUpRequest.getGender(),signUpRequest.getAddress(),signUpRequest.getAge());
    	patient.setRoles(roles);
    	
    	patientRepository.save(patient);
    	
    	
    	return ResponseEntity.ok().body("Patient registered successfully!");
    }
    
    
    @PostMapping("/signup_doctor")
    public ResponseEntity<String> registerDoctor( @RequestBody SignUpFormDoctor signUpRequest) {
    	if(userRepository.existsByPhonenumber(signUpRequest.getPhonenumber())) {
            return new ResponseEntity<String>("Fail -> Phone Number is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
 
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
 
        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getPhonenumber(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
 
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
 
        strRoles.forEach(role -> {
          switch(role) {
          case "doctor":
            Role doctorRole = roleRepository.findByName(RoleName.ROLE_DOCTOR)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
            roles.add(doctorRole);
            
            break;
          case "patient":
              Role userRole = roleRepository.findByName(RoleName.ROLE_PATIENT)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
              roles.add(userRole);              
          }
        });
        
        user.setRoles(roles);
        userRepository.save(user);
 
    	Doctor doctor = new Doctor(signUpRequest.getPhonenumber(),signUpRequest.getEmail(),user.getPassword(),signUpRequest.getName(),signUpRequest.getFee(),signUpRequest.getLocation(),signUpRequest.getNumber_of_patient(),signUpRequest.getVisiting_hour(),signUpRequest.getDegree(),
    								signUpRequest.getDepartment());
    	
    	doctorRepository.save(doctor);  	
    	return ResponseEntity.ok().body("Doctor registered successfully!");
    }
    
    
    
    
}

