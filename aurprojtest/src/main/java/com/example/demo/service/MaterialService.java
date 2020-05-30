package com.example.demo.service;

import com.example.demo.dao.MaterialRepo;
import com.example.demo.dao.MaterialversionRepo;
import com.example.demo.model.Material;
import com.example.demo.model.Materialversion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MaterialService {
	public MaterialRepo materialrepo;
	public MaterialversionRepo materialversionrepo;
	
	@Autowired
	public MaterialService(MaterialRepo materialrepo, MaterialversionRepo materialversionrepo) {
		
		this.materialrepo = materialrepo;
		this.materialversionrepo = materialversionrepo;
	}
	
	
	
	
	
	public void addMaterial(Material material) {
		Material temp;
		Materialversion temp1;
		temp = materialrepo.save(material);
		temp1 = new Materialversion( null , temp.getName() , temp.getId() , null );
		materialversionrepo.save(temp1);
	}
	
	public void deleteMaterial(Long id) {
		/// delete all associated records from common table
		/// fecth all records first
		
		List<Materialversion> lt;
		lt = materialversionrepo.findByMaterial(id);
		
		for(Materialversion temp : lt) {
			materialversionrepo.deleteById(temp.getId());
		}
		materialrepo.deleteById(id);
	}
	
	
	public List<Material> getMaterial() {
		return  (List<Material>)materialrepo.findAll();
	}
	
	public List<Materialversion> getVersions(Long id){
		return materialversionrepo.findByMaterial(id);
	}
	
	
	public void updateMaterial(Long id , Material material) {
		materialrepo.findById(id).map( crs->{
			crs.setName(material.getName());
			crs.setlastupdated(material.getlastupdated());
			
			Material temp;
			Materialversion temp1;
			
			temp= materialrepo.save(crs);
			temp1 = new Materialversion( temp.getId() , temp.getName() , temp.getId() ,null );
			materialversionrepo.save(temp1);
			return temp;
		})
		.orElseGet(()->{
			material.setId(id);
			Material temp;
			Materialversion temp1;
			
			temp= materialrepo.save(material);
			temp1 = new Materialversion( temp.getId() , temp.getName() , temp.getId() ,null );
			materialversionrepo.save(temp1);
			return temp;
		});
	}
}