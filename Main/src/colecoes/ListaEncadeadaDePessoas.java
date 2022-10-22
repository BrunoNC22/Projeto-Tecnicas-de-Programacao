package colecoes;

import iteradores.ListaEncadeadaConcreta;
import ordenadores.Ordenador;

public class ListaEncadeadaDePessoas implements ColecaoDePessoas{
	private ListaEncadeadaConcreta listaDePessoas = new ListaEncadeadaConcreta();
	private int totalDePessoas=0;
	@Override
	public void adicionarPessoa(Pessoa pessoa) {
		this.listaDePessoas.adicionarFim(pessoa);
		this.totalDePessoas++;
	}

	@Override
	public boolean excluirPessoa() {
		if (this.totalDePessoas>0) {
			return this.listaDePessoas.excluirFim();
			
		}
		return false;
	}

	@Override
	public Pessoa obterPessoa(int posicaoDaPessoa) {
		return this.listaDePessoas.obterDado(posicaoDaPessoa);
	}

	@Override
	public int obterTotalDePessoas() {
		return this.totalDePessoas;
	}

	@Override
	public void ordenarLista(Ordenador ordenador) {
		//ordenador.ordenarPeloMetodoQuickSort(this, 0, totalDePessoas-1);
		ordenador.ordenarPeloMetodoInsercao(this);
		//ordenador.ordenarPeloMetodoBolha(this);
		//ordenador.ordenarPeloMetodoSelecao(this);
	}

	@Override
	public void trocarPosicoesEntreDuasPessoas(int primeiraPosicao, int segundaPosicao) {
		Pessoa armazenamentoAuxiliar;
		armazenamentoAuxiliar = this.listaDePessoas.obterDado(primeiraPosicao);
		this.listaDePessoas.definirDado(primeiraPosicao, this.listaDePessoas.obterDado(segundaPosicao));
		this.listaDePessoas.definirDado(segundaPosicao, armazenamentoAuxiliar);
	}

	@Override
	public void alterarPessoa(int posicaoDaPessoa, Pessoa novaPessoa) {
		this.listaDePessoas.definirDado(posicaoDaPessoa, novaPessoa);
	}

}
