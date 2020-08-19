package projeto.spring.data.treinamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tipo;
	private String numero;
	
	@ManyToOne(optional = false)//é obrigatório
	private UsuarioSpringData usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UsuarioSpringData getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioSpringData usuario) {
		this.usuario = usuario;
	}
	
	
	
}
