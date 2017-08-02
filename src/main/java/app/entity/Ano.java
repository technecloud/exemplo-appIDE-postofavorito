package app.entity;

/**
 * Classe que representa ...
 * 
 * @author Rodrigo Gregorio Neri
 * @version 1.0
 * @since 2017-08-01
 *
 */

public class Ano {
	public String referencia;
	public String fipe_codigo;
	public String name;
	public String combustivel;
	public String marca;
	public String ano_modelo;
	public String preco;
	public String key;
	public String time;
	public String veiculo;
	public String id;

	/**
	 * Construtor
	 **/
	public Ano(String referencia, String fipe_codigo, String name, String combustivel, String marca, String ano_modelo,
			String preco, String key, String time, String veiculo, String id) {
		this.referencia = referencia;
		this.fipe_codigo = fipe_codigo;
		this.name = name;
		this.combustivel = combustivel;
		this.marca = marca;
		this.ano_modelo = ano_modelo;
		this.preco = preco;
		this.key = key;
		this.time = time;
		this.veiculo = veiculo;
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getFipe_codigo() {
		return fipe_codigo;
	}

	public void setFipe_codigo(String fipe_codigo) {
		this.fipe_codigo = fipe_codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAno_modelo() {
		return ano_modelo;
	}

	public void setAno_modelo(String ano_modelo) {
		this.ano_modelo = ano_modelo;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
