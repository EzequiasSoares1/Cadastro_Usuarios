package Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name = "Address")
@Table(name = "TB_ADDRESS")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String rua;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String PontoReferencia;
    private String pais;

	public Endereco(String rua, String numero, String cep,String cidade,String estado,String referencia,String pais) {
    	this.rua = rua;
    	this.numero = numero;
    	this.cep = cep;
    	this.cidade = cidade;
    	this.estado = estado;
    	this.PontoReferencia = referencia;
    	this.pais = pais;
    }
    
    public Endereco() {
    	
    }
  
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	} 
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPontoReferencia() {
		return PontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		PontoReferencia = pontoReferencia;
	}
    
}
