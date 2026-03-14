package com.lpu.boot1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.boot1.entity.Student;

@RestController
@RequestMapping("/abcd")
public class MyController {
	
	@GetMapping("/hi")
	public String reqhi() {
		return "byeee";
	}
	
	//URL-> http://localhost:8080/takeData?id=123&name=vignan
	@GetMapping("/takeData")
	public String takedata(
			@RequestParam int id,@RequestParam String name) {
		return "ID: "+id+" Name: "+name;
	}
	
	//URL-> http://localhost:8080/college?id=213&name=vignan&loc=phagwara
	@GetMapping("/college")
	public String takecollege(@RequestParam int id,@RequestParam String name,@RequestParam String loc) {
		return "id ="+id+" name: "+name+" Location: "+loc;
	}
	
	//URL -> http://localhost:8080/takedata/34/vignan
	@GetMapping("/takedata/{id}/{name}")
	public String takeData(@PathVariable int id,@PathVariable String name) {
		return "Id:"+id+" Name: "+name;
		
	}
	
	//URL-> http://localhost:8080/student/23/college/456
	@RequestMapping("/student/{sid}/college/{cid}")
	public String Studemt(@PathVariable int sid,@PathVariable int cid) {
		return "SID: "+sid+" Cid:"+cid;
	}
	
	@GetMapping("/studentid/college/{cid}")
	public String college(@RequestParam int id,@PathVariable int cid) {
		return "SID: "+id+"cid: "+cid;
	}
	
	//URL->http://localhost:8080/takedata4
	@GetMapping("/takedata4")
	public String getdata(@RequestHeader int id) {
		return "ID:"+ id;
	}
	
	@GetMapping("/student")
	public Student student(@RequestBody Student s) {
		return s;	
	}
}
