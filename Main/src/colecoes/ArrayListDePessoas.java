package colecoes;

import java.util.ArrayList;

import ordenadores.Ordenador;

public class ArrayListDePessoas implements ColecaoDePessoas{
	private ArrayList <Pessoa> listaDePessoas= null;
	private int totalDePessoas;

	public ArrayListDePessoas() {
		listaDePessoas = new ArrayList<Pessoa>();
		new ArrayList<Pessoa>();
		this.totalDePessoas = 0;
	}
	
	@Override
	public void adicionarPessoa(Pessoa pessoa) {
		this.listaDePessoas.add(pessoa);
		this.totalDePessoas++;
	}
	
	@Override
	public boolean excluirPessoa() {
		if (this.totalDePessoas > 0) {
			this.listaDePessoas.remove(totalDePessoas);
			this.totalDePessoas--;
			return true;
		}
		return false;
	}
	
	@Override
	public Pessoa obterPessoa(int indiceDaPessoa) {
		return this.listaDePessoas.get(indiceDaPessoa);
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
		armazenamentoAuxiliar = this.listaDePessoas.get(primeiraPosicao);
		this.listaDePessoas.set(primeiraPosicao, this.listaDePessoas.get(segundaPosicao));
		this.listaDePessoas.set(segundaPosicao, armazenamentoAuxiliar);
	}

	@Override
	public void alterarPessoa(int posicaoDaPessoa, Pessoa novaPessoa) {
		this.listaDePessoas.set(posicaoDaPessoa, novaPessoa);
	}
}
