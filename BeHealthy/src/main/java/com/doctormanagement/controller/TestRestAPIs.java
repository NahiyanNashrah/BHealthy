package com.doctormanagement.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPIs {
 
 @GetMapping("/api/test/patient")
 @PreAuthorize("hasRole('PATIENT')")
 public String userAccess() {
   return ">>> PATIENT Contents!";
 }
 
 @GetMapping("/api/test/doctor")
 @PreAuthorize("hasRole('DOCTOR')")
 public String projectManagementAccess() {
   return ">>> doctor content";
 }
}
 

