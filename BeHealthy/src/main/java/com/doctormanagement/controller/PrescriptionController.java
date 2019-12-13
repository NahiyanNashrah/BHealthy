package com.doctormanagement.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudinary.utils.ObjectUtils;
import com.doctormanagement.component.CloudinaryConfig;
import com.doctormanagement.message.response.FileResponse;
import com.doctormanagement.model.PrescriptionDetails;
import com.doctormanagement.repository.PrescriptionDetailesRepository;
import com.doctormanagement.service.PrescriptionService;
import com.doctormanagement.service.StorageServiceInterface;


@RestController
public class PrescriptionController {
	
	private StorageServiceInterface storageService;
	
    public PrescriptionController(StorageServiceInterface storageService) {
        this.storageService = storageService;
    }
    
    @Autowired
    PrescriptionDetailesRepository prescriptionDetailesRepository;
    
    @Autowired
    PrescriptionService prescriptionService;

    @Autowired
	CloudinaryConfig cloudc;
	
	
	@CrossOrigin
	@PostMapping("/api/upload-prescrption")
	@PreAuthorize("hasRole('PATIENT')")
    public FileResponse uploadMultipleFiles(@RequestPart("file") MultipartFile file, @RequestPart("prescription_detailes") PrescriptionDetails prescriptionDetailes) {
		
		
		String name = singleImageUpload(file);
        prescriptionDetailes.setImage(name);
        prescriptionDetailesRepository.save(prescriptionDetailes);

        return new FileResponse(name, name, file.getContentType(), file.getSize());
        
    }
	
	@CrossOrigin
	@GetMapping("/api/get-prescrption/{phonenumber}")
	@PreAuthorize("hasRole('PATIENT') or hasRole('DOCTOR')")
	public List<PrescriptionDetails> getAllPrescription(@PathVariable String phonenumber) {
		return prescriptionService.getPrescription(phonenumber);
	}
	
	
	
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
