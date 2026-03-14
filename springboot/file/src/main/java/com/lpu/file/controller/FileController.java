package com.lpu.file.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.file.entity.FileData;
import com.lpu.file.repository.FileRepository;

@RestController
@RequestMapping("/api")
public class FileController {
	@Autowired
	private FileRepository repo;
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException{
		FileData f=new FileData();
		f.setFileName(file.getOriginalFilename());
		f.setFileType(file.getContentType());
		f.setData(file.getBytes());
		
		FileData saved=repo.save(f);
		return "file saved"+saved.getId();
		
	}
	
	@GetMapping("download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable int id){
		FileData file=repo.findById(id)
				.orElseThrow(()-> new RuntimeException("File not found"));
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"inline;filename=\"" + file.getFileName())
				.header(HttpHeaders.CONTENT_TYPE, file.getFileType())
				.body(file.getData());
	}

}
