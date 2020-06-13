package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.service.DummyfileService;
import com.example.demo.service.ResponseDataService;
import com.fasterxml.jackson.databind.ObjectMapper;



//@SpringBootTest
//@AutoConfigureMockMvc
//class DummyfileControllerTest {
//
//	
//
//	@MockBean
//	DummyfileService dummyfileservice;
//	
//	@MockBean
//ResponseDataService resdataservice;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	public void someTest() throws Exception {
//		MockMultipartFile file =
//                new MockMultipartFile(
//                        "file",
//                        "test contract.pdf",
//                        MediaType.APPLICATION_PDF_VALUE,
//                        "<<pdf data>>".getBytes(StandardCharsets.UTF_8));
//		
//		String creator = "amey";
//		String description = "myfiletest";
//		
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        MockMultipartFile metadata =
//                new MockMultipartFile(
//                        "request",
//                        "request",
//                        MediaType.APPLICATION_JSON_VALUE,
//                        objectMapper.writeValueAsString(request).getBytes(StandardCharsets.UTF_8));
//
//        
//        mockMvc.perform(
//                multipart("/file/uploadFile")
//                        .file(file)
//                        .file(metadata)
//                        .param("creator", creator)
//        	            .param("description", description))
//                .andExpect(status().isOk());
//        
//		
////		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file/uploadFile")
////	            .file(file)
////	            .param("creator", creator)
////	            .param("description", description))
////	            .andExpect(status().isOk());
////		
//		
//	}
//	
//}
