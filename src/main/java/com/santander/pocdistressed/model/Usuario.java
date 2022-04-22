package com.santander.pocdistressed.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios", schema = "distressed")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4360267777380254668L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;

	@Column(name = "apellidos", nullable = false)

	private String apellidos;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "contrasenia", nullable = false)
	private String contrasenia;

	@Column(name = "rango", nullable = false)
	private Integer rango;

	@Column(name = "borrado")
	private Boolean borrado;

}
