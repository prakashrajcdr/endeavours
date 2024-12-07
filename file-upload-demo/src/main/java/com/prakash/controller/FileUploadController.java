package com.prakash.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prakash.entity.User;
import com.prakash.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FileUploadController {
	
	@Autowired
	UserRepository userRepository;

	@PostMapping(path="/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> upload(@RequestPart("user") User user, @RequestPart("document") MultipartFile document) {
		try {
//			for(MultipartFile document : documents) {
				
				log.info("getName - " + document.getName());
				log.info("getOriginalFilename - " + document.getOriginalFilename());
				log.info("getSize in bytes - " + document.getSize());
				log.info("getContentType - " + document.getContentType());
//				log.info("getResource().getURI - " + document.getResource().getURI());
//				log.info("getResource().getURL - " + document.getResource().getURL());
		//		log.info("getBytes - " + new String(document.getBytes(), StandardCharsets.UTF_8));
//				User user = new User();
				user.setDocument(new String(document.getBytes(), StandardCharsets.UTF_8));
				userRepository.save(user);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("File uploaded successfully");
	}
}
