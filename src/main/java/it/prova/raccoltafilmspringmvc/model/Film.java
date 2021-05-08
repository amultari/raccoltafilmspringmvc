package it.prova.raccoltafilmspringmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "film")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message = "{titolo.notblank}")
	@Size(min = 4, max = 15, message = "Il valore inserito '${validatedValue}' deve essere lungo tra {min} e {max} caratteri")
	@Column(name = "titolo")
	private String titolo;
	
	@NotBlank(message = "{genere.notblank}")
	@Column(name = "genere")
	private String genere;
	
	@NotNull(message = "{dataPubblicazione.notnull}")
	@Column(name = "datapubblicazione")
	private Date dataPubblicazione;
	
	@NotNull(message = "{minutiDurata.notnull}")
	@Min(1)
	@Column(name = "minutidurata")
	private Integer minutiDurata;

	@NotNull(message = "{regista.notnull}")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "regista_id")
	private Regista regista;

	public Film() {
	}

	public Film(Long id, String titolo, String genere, Date dataPubblicazione, Integer minutiDurata, Regista regista) {
		this.id = id;
		this.titolo = titolo;
		this.genere = genere;
		this.dataPubblicazione = dataPubblicazione;
		this.minutiDurata = minutiDurata;
		this.regista = regista;
	}

	public Film(String titolo, String genere, Date dataPubblicazione, Integer minutiDurata, Regista regista) {
		this.titolo = titolo;
		this.genere = genere;
		this.dataPubblicazione = dataPubblicazione;
		this.minutiDurata = minutiDurata;
		this.regista = regista;
	}

	public Film(String titolo, String genere) {
		this.titolo = titolo;
		this.genere = genere;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public Integer getMinutiDurata() {
		return minutiDurata;
	}

	public void setMinutiDurata(Integer minutiDurata) {
		this.minutiDurata = minutiDurata;
	}

	public Regista getRegista() {
		return regista;
	}

	public void setRegista(Regista regista) {
		this.regista = regista;
	}

}
