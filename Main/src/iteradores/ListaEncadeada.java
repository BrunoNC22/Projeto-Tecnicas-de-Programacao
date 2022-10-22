package iteradores;

import colecoes.Pessoa;

public interface ListaEncadeada {
	
	public void adicionarInicio(Pessoa pessoa);
	
	public void adicionarFim(Pessoa pessoa);
	
	public boolean adicionarMeio(int posicaoInclusao, Pessoa pessoa);
	
	public boolean excluirInicio();
	
	public boolean excluirFim();
	
	public boolean excluirMeio(int posicao);
	
	public Pessoa obterDado(int posicao);
	
	public void definirDado(int posicao, Pessoa pessoa);
	
	public int obterTotalDeElementos();
	
	@Override
	public String toString();

	Iterador obterIterador();
}

