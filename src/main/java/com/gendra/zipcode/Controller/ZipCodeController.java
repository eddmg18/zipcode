package com.gendra.zipcode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gendra.zipcode.Dto.ContenidoDto;
import com.gendra.zipcode.Service.ZipCodeService;

@RestController
public class ZipCodeController {

	@Autowired
	ZipCodeService service;
	
	@CrossOrigin
	@GetMapping(value = "/zip-codes/{zipCode}")
	public @ResponseBody ResponseEntity<?> obtenerDatosPorZipCode(@PathVariable(name = "zipCode") String zipCode) {
		ContenidoDto response = service.obtenerDatosPorZipCode(zipCode);
		if (response.getSettlements().size() > 0) {
			return new ResponseEntity<ContenidoDto>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
	}
}
