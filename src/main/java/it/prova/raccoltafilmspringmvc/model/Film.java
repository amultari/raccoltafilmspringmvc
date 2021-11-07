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

@Entity
@Table(name = "film")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "titolo")
	private String titolo;

	@Column(name = "genere")
	private String genere;

	@Column(name = "datapubblicazione")
	private Date dataPubblicazione;

	@Column(name = "minutidurata")
	private Integer minutiDurata;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "regista_id", nullable = false)
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
