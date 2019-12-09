package com.doctormanagement.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudinary.utils.ObjectUtils;
import com.doctormanagement.component.CloudinaryConfig;
import com.doctormanagement.message.request.LoginForm;
import com.doctormanagement.message.request.SignUpFormDoctor;
import com.doctormanagement.message.request.SignUpFormPatient;

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
import com.doctormanagement.service.FileSystemStorageService;

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

	@Autowired
	FileSystemStorageService fileSystemStorageService;
	
	@Autowired
	CloudinaryConfig cloudc;
	
	
	

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getPhonenumber(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return ResponseEntity.ok(jwtProvider.generateJwtToken(authentication));
	}

	@PostMapping("/signup_patient")
	public ResponseEntity<String> registerPatient(@RequestPart("file") MultipartFile file,
			@RequestPart("patient") SignUpFormPatient signUpRequest) {
		if (userRepository.existsByPhonenumber(signUpRequest.getPhonenumber())) {
			return new ResponseEntity<String>("Fail -> Phone Number is already taken!", HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getPhonenumber(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		strRoles.forEach(role -> {
			switch (role) {
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

		String name = singleImageUpload(file);

//        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/download/")
//                .path("hrllo")
//                .toUriString();
//        

		user.setRoles(roles);
		userRepository.save(user);

		Patient patient = new Patient(signUpRequest.getPhonenumber(), signUpRequest.getEmail(), user.getPassword(),
				signUpRequest.getWeight(), signUpRequest.getName(), signUpRequest.getBloodgroup(),
				signUpRequest.getGender(), signUpRequest.getAddress(), signUpRequest.getAge(), name);
		

		patientRepository.save(patient);

		return ResponseEntity.ok().body("Patient registered successfully!");
	}

	@PostMapping("/signup_doctor")
	public ResponseEntity<String> registerDoctor(@RequestPart("file") MultipartFile file,
			@RequestPart("doctor") SignUpFormDoctor signUpRequest) {
		if (userRepository.existsByPhonenumber(signUpRequest.getPhonenumber())) {
			return new ResponseEntity<String>("Fail -> Phone Number is already taken!", HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getPhonenumber(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
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
		
		//////////// ================= Image Save ====================///////////////
		
		String name = singleImageUpload(file);

		
		
		user.setRoles(roles);
		userRepository.save(user);

		Doctor doctor = new Doctor(signUpRequest.getPhonenumber(), signUpRequest.getEmail(), user.getPassword(),
				signUpRequest.getName(), signUpRequest.getFee(), signUpRequest.getLocation(),
				signUpRequest.getNumber_of_patient(), signUpRequest.getVisiting_hour(), signUpRequest.getDegree(),
				signUpRequest.getDepartment(),name);

		doctorRepository.save(doctor);
		return ResponseEntity.ok().body("Doctor registered successfully!");
	}

	
	
///////////////////// =============   Cloudinary Image Upload Testing   ==================   ////////////////////////
	public String singleImageUpload( MultipartFile file) {
		Map uploadResult = null;
		if (file.isEmpty()) {
			return "NO FILE";
		}
		try {
			uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
		} catch (IOException e) {
			e.printStackTrace();

		}
		return (String) uploadResult.get("url");
	}

}
