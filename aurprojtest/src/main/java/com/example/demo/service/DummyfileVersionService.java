package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.DummyfileVersionRepo;
import com.example.demo.model.DummyfileVersion;

@Service
public class DummyfileVersionService {
	
	@Autowired
	DummyfileVersionRepo dummyfileversionrepo;
	
	
	public DummyfileVersion getFile(Long id) {
		return dummyfileversionrepo.findById(id).get();
	}
	
	
	public DummyfileVersion storeFile(MultipartFile file , Long id) throws IOException {
		  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	       DummyfileVersion df = new DummyfileVersion(id , fileName , file.getContentType() , file.getBytes());
	       return dummyfileversionrepo.save(df);
	}
	
	
}
