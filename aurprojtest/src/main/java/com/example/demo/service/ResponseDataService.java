package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DummyfileRepo;
import com.example.demo.dao.DummyfileVersionRepo;
import com.example.demo.dao.ResponseDataRepo;
import com.example.demo.dao.ResponseDataVersionRepo;
import com.example.demo.model.ResponseData;
import com.example.demo.model.ResponseDataVersion;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ResponseDataService {
	
	
	@Autowired
	DummyfileVersionService dfvs;
	
	
	@Autowired
	ResponseDataRepo resdatarepo;
	
	@Autowired
	ResponseDataVersionRepo resdataversionrepo;
	
	@Autowired
	DummyfileRepo dummyfilerepo;
	
	
	@Autowired
	DummyfileVersionRepo dummyfileversionrepo;
	
	public void add(ResponseData rd , MultipartFile file) throws IOException {
		System.out.println("In response data service "+rd);
		
		rd = resdatarepo.save(rd);
		ResponseDataVersion rdv = new ResponseDataVersion(null , rd.getFileName(),rd.getFileDownloadUri()
				,rd.getFileType() , rd.getSize() , rd.getLastupdated(),rd.getCreator(),rd.getDescription(),rd.getId());
		
		ResponseDataVersion temp = resdataversionrepo.save(rdv);
		
		String id = String.valueOf(  temp.getId() );
		 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/file/downloadFileVersion/")
	                .path(id)
	                .toUriString();
		temp.setFileDownloadUri(fileDownloadUri);
		
		
		
		/// add in new mirror file system
		dfvs.storeFile(file, temp.getId());
		
		
	}
	
	public List<ResponseData> getall(){
		return (List<ResponseData>) resdatarepo.findAll();
	}
	
	public void update(ResponseData res , Long id  ,MultipartFile file) throws IOException {
		
		/// cascade add in ResponseDataVersion;
		ResponseDataVersion rdtemp = new ResponseDataVersion(null , res.getFileName() , res.getFileDownloadUri() , res.getFileType() , 
				res.getSize() , null , res.getCreator(),res.getDescription(),id);
		
		ResponseDataVersion temp = resdataversionrepo.save(rdtemp);
		String rid = String.valueOf(  temp.getId() );
		 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/file/downloadFileVersion/")
	                .path(rid)
	                .toUriString();
		temp.setFileDownloadUri(fileDownloadUri);
		dfvs.storeFile(file, temp.getId());
		
		
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
	
	public void delete(Long id ) {
		// delete from dummy file
		///delete from res , resver and dummy file ver 
		dummyfilerepo.deleteById(id);
		resdatarepo.deleteById(id);
		List<ResponseDataVersion> temp = resdataversionrepo.findByResponseid(id);
		
		for(ResponseDataVersion t : temp) {
			resdataversionrepo.deleteById(t.getId());
			dummyfileversionrepo.deleteById(t.getId());
		}
	}
}
