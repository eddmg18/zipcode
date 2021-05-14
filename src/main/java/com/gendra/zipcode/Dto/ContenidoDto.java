package com.gendra.zipcode.Dto;

import java.util.List;

public class ContenidoDto {

	public String zip_code;
	public String locality;
	public String federal_entity;
	public String municipality;
	public List<AsentamientoDto> settlements;
	
	public ContenidoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getFederal_entity() {
		return federal_entity;
	}

	public void setFederal_entity(String federal_entity) {
		this.federal_entity = federal_entity;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public List<AsentamientoDto> getSettlements() {
		return settlements;
	}

	public void setSettlements(List<AsentamientoDto> settlements) {
		this.settlements = settlements;
	}
	
}
