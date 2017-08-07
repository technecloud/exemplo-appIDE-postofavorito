package app.entity;


import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa ...
 * 
 * @author Rodrigo Gregorio Neri
 * @version 1.0
 * @since 2017-08-01
 *
 */


@Entity
@Table(name = "\"MODELO\"")
@XmlRootElement
public class Modelo {


	@Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
	private java.lang.String id;
	
	@Column(name = "fipe_marca", nullable = true, unique = false, insertable=true, updatable=true)
	private java.lang.String fipe_marca;
	
	@Column(name = "fipe_codigo", nullable = true, unique = false, insertable=true, updatable=true)
	private java.lang.String fipe_codigo;
	
	@Column(name = "name", nullable = true, unique = false, insertable=true, updatable=true)
	private java.lang.String name;
	
	@Column(name = "marca", nullable = true, unique = false, insertable=true, updatable=true)
	private java.lang.String marca;
	
	@Column(name = "key", nullable = true, unique = false, insertable=true, updatable=true)
	private java.lang.String key;
	
	@Column(name = "veiculo", nullable = true, unique = false, insertable=true, updatable=true)
	private java.lang.String veiculo;
	


	public Modelo() {

	}

	public java.lang.String getFipe_marca() {
		return fipe_marca;
	}

	public void setFipe_marca(java.lang.String fipe_marca) {
		this.fipe_marca = fipe_marca;
	}

	public java.lang.String getFipe_codigo() {
		return fipe_codigo;
	}

	public void setFipe_codigo(java.lang.String fipe_codigo) {
		this.fipe_codigo = fipe_codigo;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getMarca() {
		return marca;
	}

	public void setMarca(java.lang.String marca) {
		this.marca = marca;
	}

	public java.lang.String getKey() {
		return key;
	}

	public void setKey(java.lang.String key) {
		this.key = key;
	}

	public java.lang.String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(java.lang.String veiculo) {
		this.veiculo = veiculo;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

}
