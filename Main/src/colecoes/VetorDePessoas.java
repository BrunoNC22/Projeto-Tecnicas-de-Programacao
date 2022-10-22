package colecoes;

import ordenadores.Ordenador;

public class VetorDePessoas implements ColecaoDePessoas{
	private Pessoa listaDePessoas[];
	private int totalDePessoas;

	public VetorDePessoas() {
		this.listaDePessoas = new Pessoa[1094379];
		this.totalDePessoas = 0;
	}
	
	public VetorDePessoas(int tamanhoMaximoDaLista) {
		this.listaDePessoas = new Pessoa[tamanhoMaximoDaLista];
		this.totalDePessoas = 0;
	}
	
	@Override
	public void adicionarPessoa(Pessoa pessoa) {
		this.listaDePessoas[totalDePessoas] = pessoa;
		this.totalDePessoas++;
	}
	
	@Override
	public boolean excluirPessoa() {
		if (this.totalDePessoas > 0) {
			this.totalDePessoas--;
			return true;
		}
		return false;
	}
	
	@Override
	public Pessoa obterPessoa(int indiceDaPessoa) {
		return this.listaDePessoas[indiceDaPessoa];
	}
	
	@Override
	public int obterTotalDePessoas() {
		return this.totalDePessoas;
	}

	@Override
	public void ordenarLista(Ordenador ordenador) {
		ordenador.ordenarPeloMetodoQuickSort(this, 0, totalDePessoas-1);
	}

	@Override
	public void trocarPosicoesEntreDuasPessoas(int primeiraPosicao, int segundaPosicao) {
		Pessoa armazenamentoAuxiliar; 
		armazenamentoAuxiliar = this.listaDePessoas[primeiraPosicao];
		this.listaDePessoas[primeiraPosicao] = this.listaDePessoas[segundaPosicao];
		this.listaDePessoas[segundaPosicao] = armazenamentoAuxiliar;
	}

	@Override
	public void alterarPessoa(int posicaoDaPessoa, Pessoa novaPessoa) {
		this.listaDePessoas[posicaoDaPessoa] = novaPessoa;
		
	}
}