package com.santander.pocdistressed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.santander.pocdistressed.service.FileService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("poc-api")
@Log4j2
public class FileController {

	@Autowired
	FileService fileService;
	
	@PostMapping("/uploadFiles")
	public ResponseEntity<Object> fileUpload(
			@RequestParam("File1") MultipartFile file1,
			@RequestParam("File2") MultipartFile file2,
			@RequestParam("File3") MultipartFile file3 ) throws Exception{
		log.info("Entro al controlador");
		
		return new ResponseEntity<>(fileService.fileUpload(file1, file2, file3), HttpStatus.OK);		
	}

	
}
