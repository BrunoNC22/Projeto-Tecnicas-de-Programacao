package iteradores;

import colecoes.Pessoa;

public interface Iterador {
	
	public boolean temProximo();
	
	public Pessoa obterProximo();

}
