package ordenadores;

import colecoes.ColecaoDePessoas;
import colecoes.Pessoa;

public class OrdenadorPorAnoDeNascimento implements Ordenador {

	@Override
	public void ordenarPeloMetodoBolha(ColecaoDePessoas listaDePessoas) {
		int tamanhoDoVetor = listaDePessoas.obterTotalDePessoas();
		boolean existiuTroca;
		do {
			existiuTroca = false;
			for (int posicao = 0; posicao < tamanhoDoVetor - 1; posicao++) {
				if (listaDePessoas.obterPessoa(posicao).obterAnoDeNacimento() > listaDePessoas.obterPessoa(posicao+1).obterAnoDeNacimento()) {
					listaDePessoas.trocarPosicoesEntreDuasPessoas(posicao, posicao+1);
					existiuTroca = true;
				}
			}
		}
		while(existiuTroca);
	}

	@Override
	public void ordenarPeloMetodoSelecao(ColecaoDePessoas listaDePessoas) {
		int tamanhoDaLista = listaDePessoas.obterTotalDePessoas();
		int posicaoDoMenorValor = 0;
		for (int posicaoEmAnalise = 0; posicaoEmAnalise < tamanhoDaLista; posicaoEmAnalise++ ) {
			posicaoDoMenorValor = obterPosicaoDoMenorValor(listaDePessoas, posicaoEmAnalise);
			listaDePessoas.trocarPosicoesEntreDuasPessoas(posicaoDoMenorValor, posicaoEmAnalise);
		}
		
		
	}
	
	private static int obterPosicaoDoMenorValor(ColecaoDePessoas listaDePessoas, int posicaoDeInicio) {
		int tamanhoDaLista = listaDePessoas.obterTotalDePessoas();
		Pessoa pessoaComMenorAnoDeNascimento;
		pessoaComMenorAnoDeNascimento = listaDePessoas.obterPessoa(posicaoDeInicio);
		int posicaoParaTroca = posicaoDeInicio;
		for (int posicaoAvaliada = posicaoDeInicio + 1; posicaoAvaliada < tamanhoDaLista; posicaoAvaliada++) {
			if (listaDePessoas.obterPessoa(posicaoAvaliada).obterAnoDeNacimento() < pessoaComMenorAnoDeNascimento.obterAnoDeNacimento()) {
				pessoaComMenorAnoDeNascimento = listaDePessoas.obterPessoa(posicaoAvaliada);
				posicaoParaTroca = posicaoAvaliada;
			}
		}
		return posicaoParaTroca;
	}

	@Override
	public void ordenarPeloMetodoInsercao(ColecaoDePessoas listaDePessoas) {
		int tamanhoDoVetor = listaDePessoas.obterTotalDePessoas();
		Pessoa pessoaParaSerTrocada;
		
		for (int posicaoEmAvaliacao = 1; posicaoEmAvaliacao < tamanhoDoVetor; posicaoEmAvaliacao++) {
			pessoaParaSerTrocada = listaDePessoas.obterPessoa(posicaoEmAvaliacao);
			
			for ( int posEmAval2 = 0; posEmAval2 < posicaoEmAvaliacao; posEmAval2++) {
				if (pessoaParaSerTrocada.obterAnoDeNacimento() < listaDePessoas.obterPessoa(posEmAval2).obterAnoDeNacimento()) {
					
					for (int cont = posicaoEmAvaliacao; cont > posEmAval2; cont--) {
						listaDePessoas.alterarPessoa(cont, listaDePessoas.obterPessoa(cont - 1));
					}
					
					listaDePessoas.alterarPessoa(posEmAval2, pessoaParaSerTrocada);
					break;
				}
			}
		}
	}

	@Override
	public void ordenarPeloMetodoQuickSort(ColecaoDePessoas listaDePessoas, int inicio, int fim) {
		int posicaoPivo;
		
		if (fim > inicio) {
			posicaoPivo = particionarVetor(listaDePessoas, inicio, fim);
			ordenarPeloMetodoQuickSort(listaDePessoas, inicio, posicaoPivo - 1);
			ordenarPeloMetodoQuickSort(listaDePessoas, posicaoPivo + 1, fim);
		}
	}
	
	private int particionarVetor(ColecaoDePessoas listaDePessoas, int inicio, int fim) {
		int esquerda, direita;
		Pessoa pivo;
		esquerda = inicio;
		direita = fim;
		pivo= listaDePessoas.obterPessoa(inicio);
		
		while(direita > esquerda) {
			while (listaDePessoas.obterPessoa(esquerda).obterAnoDeNacimento() <= pivo.obterAnoDeNacimento() && esquerda < fim) {
				esquerda++;
			}
			while (listaDePessoas.obterPessoa(direita).obterAnoDeNacimento() > pivo.obterAnoDeNacimento() && direita > inicio) {
				direita--;
			}
			if (esquerda < direita) {
				listaDePessoas.trocarPosicoesEntreDuasPessoas(esquerda, direita);
			}
		}
		listaDePessoas.alterarPessoa(inicio, listaDePessoas.obterPessoa(direita));
		listaDePessoas.alterarPessoa(direita, pivo);
		return direita;
	}
}
