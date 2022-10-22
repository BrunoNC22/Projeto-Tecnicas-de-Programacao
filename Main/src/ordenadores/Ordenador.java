package ordenadores;

import colecoes.ColecaoDePessoas;

public interface Ordenador {
	public void ordenarPeloMetodoBolha(ColecaoDePessoas listaDePessoas);
		
	public void ordenarPeloMetodoSelecao(ColecaoDePessoas listaDePessoas);
	
	public void ordenarPeloMetodoInsercao(ColecaoDePessoas listaDePessoas);

	public void ordenarPeloMetodoQuickSort(ColecaoDePessoas listaDePessoas, int inicio, int fim);
}
