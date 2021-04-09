package com.mycompany.datamapper.web.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.datamapper.service.MappingService;
import com.mycompany.datamapper.web.rest.dto.InputData;
import com.mycompany.datamapper.web.rest.dto.OutputData;

import io.atlasmap.api.AtlasContext;
import io.atlasmap.core.AtlasMappingUtil;
import io.atlasmap.core.DefaultAtlasContext;

@RestController
@RequestMapping("/map")
public class MapResource {
	
	private MappingService mappingService;
	
	public MapResource(MappingService mappingService) {
		this.mappingService = mappingService;
	}
	
	@PostMapping
	public ResponseEntity<OutputData> map(@RequestBody InputData i){
		
		
		return ResponseEntity.ok(mappingService.map(i));
	}

}
