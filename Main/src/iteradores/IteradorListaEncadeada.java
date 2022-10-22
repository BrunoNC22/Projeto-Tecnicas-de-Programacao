package iteradores;

import colecoes.Pessoa;

public class IteradorListaEncadeada implements Iterador {
	No noAtual; 
	
	public IteradorListaEncadeada(No no) {
		this.noAtual = no;
	}
	
	@Override
	public boolean temProximo() {
		if (this.noAtual != null) {
			return true;
		}
		return false;
	}

	@Override
	public Pessoa obterProximo() {
		if (temProximo()) {
			No noAuxiliar = this.noAtual.obterProximo();
			return noAuxiliar.obterPessoa();
		}
		return null;
	}

}
