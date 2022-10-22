package colecoes;

public class Pessoa {
	private String nome, descricao, genero, pais, ocupacao;
	int anoDeNacimento, anoDeFalecimento;
	
	public Pessoa(String nome, String descricao, String genero, String pais, String ocupacao, int anoDeNacimento, int anoDeFalecimento) {
		this.nome = nome;
		this.descricao = descricao;
		this.genero = genero;
		this.pais = pais;
		this.ocupacao = ocupacao;
		this.anoDeNacimento = anoDeNacimento;
		this.anoDeFalecimento = anoDeFalecimento;		
	}

	public String obterNome() {
		return nome;
	}

	public void definirNome(String nome) {
		this.nome = nome;
	}

	public String obterDescricao() {
		return descricao;
	}

	public void definirDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String obterGenero() {
		return genero;
	}

	public void definirGenero(String genero) {
		this.genero = genero;
	}

	public String obterPais() {
		return pais;
	}

	public void definirPais(String pais) {
		this.pais = pais;
	}

	public String obterOcupacao() {
		return ocupacao;
	}

	public void definirOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public int obterAnoDeNacimento() {
		return anoDeNacimento;
	}

	public void definirAnoDeNacimento(int anoDeNacimento) {
		this.anoDeNacimento = anoDeNacimento;
	}

	public int obterAnoDeFalecimento() {
		return anoDeFalecimento;
	}

	public void definirAnoDeFalecimento(int anoDeFalecimento) {
		this.anoDeFalecimento = anoDeFalecimento;
	}
}
