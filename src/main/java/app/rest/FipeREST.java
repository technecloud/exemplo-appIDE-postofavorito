package app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import app.business.AnoBusiness;
import app.business.MarcasBusiness;
import app.business.ModelosBusiness;
import app.business.VeiculosBusiness;
import app.entity.Ano;
import app.entity.Marca;
import app.entity.Modelo;
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
	}

	@RequestMapping(method = RequestMethod.GET, value = "/posto/todosVeiculos/{marca}")
	public ResponseEntity<?> getVeiculos(@PathVariable("marca") String marca) {
		List<Veiculos> veiculosResponse = veiculosBusiness.listarTodosveiculos(marca);
		
		return	veiculosResponse == null ? ResponseEntity.status(400).build()
					: ResponseEntity.status(HttpStatus.CREATED).body(veiculosResponse);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/posto/todosModelos")
	public ResponseEntity<?> getModelos() {
		List<Modelo> modelosResponse = modelosBusiness.listarTodosmodelos();
		
		return	modelosResponse == null ? ResponseEntity.status(400).build()
					: ResponseEntity.status(HttpStatus.CREATED).body(modelosResponse);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/posto/todosModelosPorAno")
	public ResponseEntity<?> getModelosPorAno() {
		Ano anoResponse = anoBusiness.listarTodosVeiculosPorAno();
		
		return	anoResponse == null ? ResponseEntity.status(400).build()
					: ResponseEntity.status(HttpStatus.CREATED).body(anoResponse);
	}

}
