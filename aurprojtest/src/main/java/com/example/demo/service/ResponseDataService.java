package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ResponseDataRepo;
import com.example.demo.dao.ResponseDataVersionRepo;
import com.example.demo.model.ResponseData;
import com.example.demo.model.ResponseDataVersion;

@Service
public class ResponseDataService {
	
	
	@Autowired
	ResponseDataRepo resdatarepo;
	
	@Autowired
	ResponseDataVersionRepo resdataversionrepo;
	public void add(ResponseData rd) {
		System.out.println("In response data service "+rd);
		
		rd = resdatarepo.save(rd);
		ResponseDataVersion rdv = new ResponseDataVersion(null , rd.getFileName(),rd.getFileDownloadUri()
				,rd.getFileType() , rd.getSize() , rd.getLastupdated(),rd.getCreator(),rd.getDescription(),rd.getId());
		
		resdataversionrepo.save(rdv);
	}
	
	public List<ResponseData> getall(){
		return (List<ResponseData>) resdatarepo.findAll();
	}
	
	public void update(ResponseData res , Long id ) {
		
		/// cascade add in ResponseDataVersion;
		ResponseDataVersion rdtemp = new ResponseDataVersion(null , res.getFileName() , res.getFileDownloadUri() , res.getFileType() , 
				res.getSize() , null , res.getCreator(),res.getDescription(),id);
		
		resdataversionrepo.save(rdtemp);
		
		resdatarepo.findById(id).map( rd ->{
			rd.setCreator(res.getCreator());
			rd.setDescription(res.getDescription());
			rd.setFileDownloadUri(res.getFileDownloadUri());
			rd.setFileName(res.getFileName());
			rd.setFileType(res.getFileType());
			rd.setSize(res.getSize());
			rd.setId(res.getId());
			return resdatarepo.save(rd);
		});
	}
	
	public List<ResponseDataVersion> getVersions(Long id){
		return resdataversionrepo.findByResponseid(id);
	}
	
	
	
	
}
