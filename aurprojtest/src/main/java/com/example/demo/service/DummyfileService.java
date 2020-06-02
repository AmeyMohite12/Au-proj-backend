package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.DummyfileRepo;
import com.example.demo.model.Dummyfile;


@Service
public class DummyfileService {
	
	@Autowired
	DummyfileRepo dummyfilerepo ;
	
	public Dummyfile storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Dummyfile df = new Dummyfile(null , fileName , file.getContentType() , file.getBytes());
        return dummyfilerepo.save(df);
        
	}
	
	public Dummyfile getFile(Long id) {
		return (dummyfilerepo.findById(id)).get();
	}
	
}
