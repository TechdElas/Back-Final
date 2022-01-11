package org.generation.techdelas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPostagem;

	@NotBlank(message = "Ops! O campo titulo NÃO pode ficar em branco.")
	@Size(min = 5, max = 30, message = "O campo titulo tem no mínimo 5 caracteres e no máximo 30.") //
	private String titulo;

	@NotBlank(message = "Ops! O campo texto NÃO pode ficar em branco")
	@Size(min = 10, max = 255, message = "O campo texto tem no mínimo 10 caracteres e no máximo 255.")
	private String texto;
		

	@Temporal(TemporalType.TIMESTAMP) // Esse método printa a data e
	private Date date = new java.sql.Date(System.currentTimeMillis()); // hora da postagem em tempo real!!

	@Size(min = 10, max = 255, message = "O campo midia tem no minimo 10 caracteres e no máximo 255.")
	private String midia;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	public long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
