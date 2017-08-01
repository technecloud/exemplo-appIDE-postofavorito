package app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import app.business.MarcasBusiness;
import app.business.VeiculosBusiness;
import app.business.ModelosBusiness;
import app.business.AnoBusiness;
import app.entity.Marca;
import app.entity.Veiculos;
import app.entity.Modelo;
import app.entity.Ano;

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
public class FipeREST {

	@Autowired
	@Qualifier("MarcasBusiness")
	private MarcasBusiness marcasBusiness;

	@Autowired
	@Qualifier("VeiculosBusiness")
	private VeiculosBusiness veiculosBusiness;

	@Autowired
	@Qualifier("ModelosBusiness")
	private ModelosBusiness modelosBusiness;

	@Autowired
	@Qualifier("AnoBusiness")
	private AnoBusiness anoBusiness;

	@RequestMapping(method = RequestMethod.GET, value = "/posto/todasMarcas")
	public ResponseEntity<?> getMarcas() {
		List<Marca> marcasResponse = marcasBusiness.listarTodasMarcas();
		
	return	marcasResponse == null ? ResponseEntity.status(400).build()
					: ResponseEntity.status(HttpStatus.CREATED).body(marcasResponse);
					
	//	return ResponseEntity.ok(marcasResponse);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/posto/todosVeiculos")
	public ResponseEntity<?> getVeiculos() {
		List<Veiculos> veiculosResponse = veiculosBusiness.listarTodosveiculos();
		
		return	veiculosResponse == null ? ResponseEntity.status(400).build()
					: ResponseEntity.status(HttpStatus.CREATED).body(veiculosResponse);
	//	return ResponseEntity.ok(veiculosResponse);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/posto/todosModelos")
	public ResponseEntity<?> getModelos() {
		List<Modelo> modelosResponse = modelosBusiness.listarTodosmodelos();
		
		return	modelosResponse == null ? ResponseEntity.status(400).build()
					: ResponseEntity.status(HttpStatus.CREATED).body(modelosResponse);
		
	//	return ResponseEntity.ok(modelosResponse);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/posto/todosModelosPorAno")
	public ResponseEntity<?> getModelosPorAno() {
		System.out.println("erro "+anoBusiness.listarTodosVeiculosPorAno());
		List<Ano> anoResponse = anoBusiness.listarTodosVeiculosPorAno();
		System.out.println(anoResponse);
		
		return	anoResponse == null ? ResponseEntity.status(400).build()
					: ResponseEntity.status(HttpStatus.CREATED).body(anoResponse);
		
		// return ResponseEntity.ok(anoResponse);
	}

}
