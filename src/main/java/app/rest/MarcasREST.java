package app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.business.MarcasBusiness;
import app.business.VeiculosBusiness;
import app.entity.Marcas;
import app.entity.Veiculos;

/**
 * Classe que representa ...
 * 
 * @author Rodrigo Gregorio Neri
 * @version 1.0
 * @since 2017-08-01
 *
 */

@RestController
@RequestMapping(value = "/api/rest/Carros")
public class MarcasREST {

	@Autowired
	@Qualifier("MarcasBusiness")
	private MarcasBusiness marcasBusiness;
	
	@Autowired
	@Qualifier("VeiculosBusiness")
	private VeiculosBusiness veiculosBusiness;	

	@RequestMapping(method = RequestMethod.GET, value = "/posto/todasMarcas")
	public ResponseEntity<?> getMarcas() {
		List<Marcas> marcasResponse = marcasBusiness.listarTodasMarcas();
		return ResponseEntity.ok(marcasResponse);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/posto/todosVeiculos")
	public ResponseEntity<?> getVeiculos() {
		List<Veiculos> marcasResponse = veiculosBusiness.listarTodasveiculos();
		return ResponseEntity.ok(marcasResponse);
	}

}
