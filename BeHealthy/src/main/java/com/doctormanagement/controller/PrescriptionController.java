package com.doctormanagement.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.doctormanagement.message.response.FileResponse;
import com.doctormanagement.model.Patient;
import com.doctormanagement.model.PrescriptionDetails;
import com.doctormanagement.repository.PrescriptionDetailesRepository;
import com.doctormanagement.service.StorageServiceInterface;


@RestController
public class PrescriptionController {
	
	private StorageServiceInterface storageService;
	
    public PrescriptionController(StorageServiceInterface storageService) {
        this.storageService = storageService;
    }
    
    @Autowired
    PrescriptionDetailesRepository prescriptionDetailesRepository;

	
	@PostMapping("/api/upload-prescrption")
	@PreAuthorize("hasRole('PATIENT')")
    public FileResponse uploadMultipleFiles(@RequestPart("file") MultipartFile file, @RequestPart("prescription_detailes") PrescriptionDetails prescriptionDetailes) {
		
		
		String name = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(name)
                .toUriString();
        
        prescriptionDetailes.setImage(uri);
        prescriptionDetailesRepository.save(prescriptionDetailes);

        return new FileResponse(name, uri, file.getContentType(), file.getSize());
        
    }
}
