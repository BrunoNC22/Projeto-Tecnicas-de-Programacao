package iteradores;

import colecoes.Pessoa;

public class No {
	private Pessoa pessoa;
	private No proximo;
	
	public No(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa obterPessoa() {
		return pessoa;
	}

	public void definirPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public No obterProximo() {
		return proximo;
	}

	public void definirProximo(No proximo) {
		this.proximo = proximo;
	}
	
	
	
	

}
