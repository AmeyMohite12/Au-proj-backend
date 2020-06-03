package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dummyfile;
import com.example.demo.model.ResponseData;
import com.example.demo.model.ResponseDataVersion;
import com.example.demo.service.DummyfileService;
import com.example.demo.service.ResponseDataService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequestMapping("/file")
@RestController()
@CrossOrigin
public class DummyfileController {
	
	@Autowired
	DummyfileService dummyfileservice;
	
	@Autowired
	ResponseDataService resdataservice;
	
	@PostMapping("/uploadFile")
	public void uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("creator") String creator , @RequestParam("description") String description) throws IOException {
		System.out.println("I am here");
    	Dummyfile fileName = dummyfileservice.storeFile(file);

		String id = String.valueOf(  fileName.getId() );
		 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/file/downloadFile/")
	                .path(id)
	                .toUriString();
		
		 	ResponseData rd = new ResponseData(  fileName.getId() ,  fileName.getFileName(), fileDownloadUri,
	                file.getContentType(), file.getSize() , null,  creator,description);		 	
		 System.out.println(rd);
		 	 resdataservice.add(rd,  file);
	
	
	
	
	}
	
	
	@PostMapping("/updateFile")
	public void updateFile(@RequestParam("file") MultipartFile file,
			@RequestParam("creator") String creator ,
			@RequestParam("description") String description,
			@RequestParam("rid") Long rid) throws IOException {
			/// update exisyting record in main dummy file
		
		 dummyfileservice.updateFile(file, rid);

		 
		 Dummyfile fileName = dummyfileservice.getFile(rid);
		 
		 
		 String id = String.valueOf(  fileName.getId() );
		 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/file/downloadFile/")
	                .path(id)
	                .toUriString();
		 
		 ResponseData rd = new ResponseData(  fileName.getId() ,  fileName.getFileName(), fileDownloadUri,
	                file.getContentType(), file.getSize() , null,  creator,description);		
			
		 resdataservice.update(rd, rid , file);
	}
	
	
	
	@GetMapping("/getall")
	public List<ResponseData> getAllFiles(){
		return resdataservice.getall();
	} 
	
	
	
	@GetMapping("/get/{id}")
	public List<ResponseDataVersion> getVersions(@PathVariable Long id){
		return resdataservice.getVersions(id);
	
	} 
	
	
	

}
