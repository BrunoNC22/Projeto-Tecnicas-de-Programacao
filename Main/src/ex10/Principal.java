 package ex10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import colecoes.ArrayListDePessoas;
import colecoes.ColecaoDePessoas;
import colecoes.ListaEncadeadaDePessoas;
import colecoes.VetorDePessoas;
import dataset.DatasetPessoas;
import ordenadores.OrdenadorPorAnoDeNascimento;



public class Principal {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		DatasetPessoas datasetpessoas = new DatasetPessoas();
		String caminhoDoArquivo = "C:\\Users\\the_b\\Documents\\Eclipse-workspace\\Exercicio10\\src\\dataset\\DatasetPessoasResumido.csv";
		ColecaoDePessoas listaDePessoas;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Como deseja criar a coleção de pessoas?\n"
				+ "1 = ArrayList\n"
				+ "2 = Vetor\n"
				+ "3 = Lista encadeada");
		int opcaoEscolhida = teclado.nextInt();
		if (opcaoEscolhida == 1) {
			listaDePessoas = datasetpessoas.lerDoArquivo(caminhoDoArquivo, new ArrayListDePessoas());
		}
		else if (opcaoEscolhida == 2){
			listaDePessoas = datasetpessoas.lerDoArquivo(caminhoDoArquivo, new VetorDePessoas());
		}
		else {
			listaDePessoas = datasetpessoas.lerDoArquivo(caminhoDoArquivo, new ListaEncadeadaDePessoas());
		}
		
		for (int cont = 0; cont<listaDePessoas.obterTotalDePessoas(); cont++) {
			System.out.println(listaDePessoas.obterPessoa(cont).obterNome() + " " + listaDePessoas.obterPessoa(cont).obterAnoDeNacimento());
		}
		
		System.out.println("\n------- Lista após ser ordenada -------\n");
		
		listaDePessoas.ordenarLista(new OrdenadorPorAnoDeNascimento());
		for (int cont = 0; cont<listaDePessoas.obterTotalDePessoas(); cont++) {
			System.out.println(listaDePessoas.obterPessoa(cont).obterNome() + " " + listaDePessoas.obterPessoa(cont).obterAnoDeNacimento());
		}
		
	}

}
