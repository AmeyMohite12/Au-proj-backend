package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class ResponseData {
	
		@Id
		private Long id;
	    private String fileName;
	    private String fileDownloadUri;
	    private String fileType;
	    private long size;
		@UpdateTimestamp
		private Date lastupdated;
		
		private String creator;
	    
	    
	    private String description;
	    
		public ResponseData(Long id, String fileName, String fileDownloadUri, String fileType, long size, Date lastupdated , String creator , String description) {
			super();
			this.id = id;
			this.fileName = fileName;
			this.fileDownloadUri = fileDownloadUri;
			this.fileType = fileType;
			this.size = size;
			this.lastupdated = lastupdated;
			this.creator = creator;
			this.description = description;
		}
		
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		ResponseData(){}
		
		

		public String getCreator() {
			return creator;
		}

		public void setCreator(String creator) {
			this.creator = creator;
		}

		public Date getLastupdated() {
			return lastupdated;
		}

		public void setLastupdated(Date lastupdated) {
			this.lastupdated = lastupdated;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getFileDownloadUri() {
			return fileDownloadUri;
		}
		public void setFileDownloadUri(String fileDownloadUri) {
			this.fileDownloadUri = fileDownloadUri;
		}
		public String getFileType() {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		public long getSize() {
			return size;
		}
		public void setSize(long size) {
			this.size = size;
		}

}
