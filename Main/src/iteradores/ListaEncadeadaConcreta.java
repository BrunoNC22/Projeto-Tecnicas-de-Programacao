package iteradores;

import colecoes.Pessoa;

public class ListaEncadeadaConcreta implements ListaEncadeada{

	No inicio = null;
	int totalDeElementos = 0;
	
	public void adicionarInicio(Pessoa pessoa) {
		No novoNo = new No(pessoa);
		novoNo.definirProximo(this.inicio);
		this.inicio = novoNo;
		this.totalDeElementos++;
	}

	
	public void adicionarFim(Pessoa pessoa) {
		No novoNo = new No(pessoa);
		No noAtual = this.inicio;
		if (this.inicio != null) {
			while (noAtual.obterProximo() != null) {
				noAtual = noAtual.obterProximo();
			}
			noAtual.definirProximo(novoNo);
		}
		else {
			this.inicio = novoNo;
		}
		this.totalDeElementos++;
	}
	
	
	
	public boolean excluirInicio() {
		if (this.inicio != null) {
			this.inicio.definirProximo(inicio);
			this.totalDeElementos--;
			return true;
		}
		return false;
	}
	
	
	public boolean excluirFim() {
		No noAtual = this.inicio;
		No noAnterior = null;
		
		if (this.inicio != null) {
			while (noAtual.obterProximo() != null) {
			noAnterior = noAtual;
			noAtual = noAtual.obterProximo();
			}
			if (noAnterior != null) {
				noAnterior.definirProximo(null);
			}
			else {
				this.inicio = null;
			}
			this.totalDeElementos--;
			return true;
		}
		return false;
	}


	@Override
	public boolean adicionarMeio(int posicaoInclusao, Pessoa pessoa) {
		if ((posicaoInclusao >= 0) && (posicaoInclusao < this.totalDeElementos)) {
			No novoNo = new No(pessoa);
			No noAtual = this.inicio;
			if (this.inicio != null) {
				for (int cont = 0; cont < posicaoInclusao; cont++) {
					noAtual.definirProximo(noAtual);
				}
				noAtual.definirProximo(novoNo);
			}
			else {
				this.inicio = novoNo;
			}
			this.totalDeElementos++;
			return true;
		}
		return false;
	}


	@Override
	public boolean excluirMeio(int posicao) {
		if (posicao == 0) {
			this.inicio = this.inicio.obterProximo();
			this.totalDeElementos--;
			return true;
		}
		
		else if ((posicao > 0) && (posicao < this.totalDeElementos)) {
			No noAtual = this.inicio;
			No noAnterior = null;
			for (int cont = 0 ; cont <= posicao ; cont ++) {
				noAnterior = noAtual;
				noAtual = noAtual.obterProximo();
			}
			noAnterior = noAtual.obterProximo();
			this.totalDeElementos--;
			return true;
		}
		return false;
	}


	@Override
	public Pessoa obterDado(int posicao) {
		if ((posicao >= 0) && (posicao < this.totalDeElementos)) {
			No noAtual = this.inicio;
			for (int cont = 0 ; cont < posicao; cont++) {
				noAtual = noAtual.obterProximo();
			}
			return noAtual.obterPessoa();
		}
		return null;
	}
	
	public void definirDado(int posicao, Pessoa pessoa) {
		if ((posicao >= 0) && (posicao < this.totalDeElementos)) {
			No noAtual = this.inicio;
			for (int cont = 0 ; cont < posicao; cont++) {
				noAtual = noAtual.obterProximo();
			}
			noAtual.definirPessoa(pessoa);
		}
	}

	@Override
	public int obterTotalDeElementos() {
		return this.totalDeElementos;
	}


	@Override
	public Iterador obterIterador() {
		Iterador iterador = new IteradorListaEncadeada(this.inicio);
		return iterador;
	}

}