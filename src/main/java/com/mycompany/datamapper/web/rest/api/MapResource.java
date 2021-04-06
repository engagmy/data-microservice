package com.mycompany.datamapper.web.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.datamapper.web.rest.dto.InputData;
import com.mycompany.datamapper.web.rest.dto.OutputData;

@RestController
@RequestMapping("/map")
public class MapResource {
	
	
	
	@PostMapping
	public ResponseEntity<OutputData> map(@RequestBody InputData i){
		
		
		return ResponseEntity.of(null);
	}

}
