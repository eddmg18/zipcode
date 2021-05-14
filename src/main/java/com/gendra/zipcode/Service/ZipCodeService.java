package com.gendra.zipcode.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gendra.zipcode.Dto.AsentamientoDto;
import com.gendra.zipcode.Dto.ContenidoDto;

@Service
public class ZipCodeService {

	public ContenidoDto obtenerDatosPorZipCode(String zipCode) {
		ContenidoDto response = new ContenidoDto();
		List<AsentamientoDto> listaAsentamientos = new ArrayList<AsentamientoDto>();
		try {
			URLConnection conexion = new URL("https://storage.googleapis.com/zipcode-313618.appspot.com/CPdescarga.txt").openConnection();
			InputStream inputStream = conexion.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String[] titulos = new String[0];
			int i = 0;
			String linea = "";
			Boolean bandera = true, primerNodo = true;
			while((linea = br.readLine()) != null) {
				i += 1;
				if(i != 1 && bandera) {
					titulos = linea.split("\\|");
					bandera = false;
				} else if(i != 1) {
					if(linea.endsWith("|")) {
						linea = linea.concat(" ");
					}
					String [] cuerpo = linea.replace("||", "| |").split("\\|");
					if (cuerpo[0].equals(zipCode)) {
						AsentamientoDto asentamiento = new AsentamientoDto();
						if(primerNodo) {
							response.setZip_code(cuerpo[0]);
							response.setFederal_entity(cuerpo[5]);
							response.setLocality(cuerpo[4]);
							response.setMunicipality(cuerpo[3]);
							primerNodo = false;
						}
						asentamiento.setName(cuerpo[1]);
						asentamiento.setZone_type(cuerpo[cuerpo.length - 2]);
						asentamiento.setSettlement_type(cuerpo[2]);
						listaAsentamientos.add(asentamiento);
					}
				}
			}
			br.close();
			response.setSettlements(listaAsentamientos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return response;
	}
}
