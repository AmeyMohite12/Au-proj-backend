package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dummyfile;
import com.example.demo.payload.Response;
import com.example.demo.service.DummyfileService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequestMapping("/file")
@RestController()
@CrossOrigin
public class DummyfileController {
	
	@Autowired
	DummyfileService dummyfileservice;
	
	@PostMapping("/uploadFile")
	public Response uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("I am here");
    	Dummyfile fileName = dummyfileservice.storeFile(file);

		String id = String.valueOf(  fileName.getId() );
		 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/file/downloadFile/")
	                .path(id)
	                .toUriString();

	        return new Response(fileName.getFileName(), fileDownloadUri,
	                file.getContentType(), file.getSize());
	
	}
	
	

}
