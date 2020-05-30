package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Material;
import com.example.demo.model.Materialversion;
import com.example.demo.service.MaterialService;


@RequestMapping("/material")
@RestController
@CrossOrigin
public class MaterialController {

	MaterialService materialservice;

	
	@Autowired
	public MaterialController(MaterialService materialservice) {
		this.materialservice = materialservice;
	}
	
	 @PostMapping("/post")
		public void addCourse(@RequestBody Material material ) {
		 materialservice.addMaterial(material);
		}	
	
	 @PostMapping("/update/{id}")
	 public void updateMaterial(@RequestBody Material material , @PathVariable Long id) {
		 	materialservice.updateMaterial( id,material);
	 }
	 
	 
	 @DeleteMapping("/delete/{id}")
	 public void deleteMaterial( @PathVariable Long id) {
		 materialservice.deleteMaterial(id);
	 }
	 
	 
	 @GetMapping("/get")
	 public List<Material> getMaterial() {
		 return materialservice.getMaterial();
	 }
	 
	 
	 @GetMapping("/get/{id}")
	 public List<Materialversion> getVersion( @PathVariable Long id){
		 return materialservice.getVersions(id);
	 }
	 
	 
}
