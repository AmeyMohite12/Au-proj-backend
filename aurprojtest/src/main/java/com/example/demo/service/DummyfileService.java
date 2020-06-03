package com.example.demo.service;

import java.io.IOException;
import java.util.List;

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
	
	public List<Dummyfile> getAllFiles(){
		return dummyfilerepo.findAll();
	} 
	
	public void updateFile(MultipartFile file , Long id) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		dummyfilerepo.findById(id).map( f->{
			try {
				f.setData(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f.setFileName(fileName);
			f.setFileType(file.getContentType());
			Dummyfile dummytemp =  dummyfilerepo.save(f);
			
			return dummytemp;
		
		}).orElseGet(()->{
			return null;
		});
		
		
	
	
	}
	
	
	
}
