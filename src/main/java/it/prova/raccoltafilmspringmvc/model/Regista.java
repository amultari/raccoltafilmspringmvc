package it.prova.raccoltafilmspringmvc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "regista")
public class Regista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "{nome.notblank}")
	@Column(name = "nome")
	private String nome;

	@NotBlank(message = "{cognome.notblank}")
	@Column(name = "cognome")
	private String cognome;

	@NotBlank(message = "{nickName.notblank}")
	@Size(min = 3, max = 15, message = "Il valore inserito '${validatedValue}' deve essere lungo tra {min} e {max} caratteri")
	@Column(name = "nickname")
	private String nickName;

	@NotNull(message = "{dataDiNascita.notnull}")
	@Column(name = "datadinascita")
	private Date dataDiNascita;

	@NotNull(message = "{sesso.notblank}")
	@Column(name = "sesso")
	@Enumerated(EnumType.STRING)
	private Sesso sesso;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "regista")
	private Set<Film> films = new HashSet<Film>(0);

	public Regista() {
	}

	public Regista(Long id, String nome, String cognome, String nickName, Date dataDiNascita, Sesso sesso) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.nickName = nickName;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
	}

	public Regista(String nome, String cognome, String nickName, Date dataDiNascita, Sesso sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.nickName = nickName;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
	}

	public Regista(String nome, String cognome, String nickName, Sesso sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.nickName = nickName;
		this.sesso = sesso;
	}

	public Regista(String nome, String cognome, String nickName) {
		this.nome = nome;
		this.cognome = cognome;
		this.nickName = nickName;
	}

	public Regista(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

}
