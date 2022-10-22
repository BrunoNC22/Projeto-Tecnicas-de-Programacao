package dataset;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import colecoes.ColecaoDePessoas;
import colecoes.Pessoa;

public class DatasetPessoas {
	public ColecaoDePessoas lerDoArquivo(String caminhoDoArquivo, ColecaoDePessoas listaDePessoas) throws FileNotFoundException, IOException {
		FileReader fluxoDeLeituraDeArquivoTexto = new FileReader(caminhoDoArquivo);
		BufferedReader leituraBufferizada = new BufferedReader(fluxoDeLeituraDeArquivoTexto);
		String listaDeCampos[];
		
		Pessoa pessoa = null;
		int numeroPessoa = 0;
		
		String linhaLidaDoArquivo = leituraBufferizada.readLine();
		while (linhaLidaDoArquivo != null) {		
			listaDeCampos = linhaLidaDoArquivo.split(",");
			if (listaDeCampos.length == 10) {
				try {
					int anoDeNascimento = Integer.parseInt(listaDeCampos[6]);
					int anoDeFalecimento = Integer.parseInt(listaDeCampos[7]);
					pessoa = new Pessoa(listaDeCampos[1],listaDeCampos[2],listaDeCampos[3],listaDeCampos[4],listaDeCampos[5],anoDeNascimento,anoDeFalecimento);
					listaDePessoas.adicionarPessoa(pessoa);
				}
				catch(java.lang.NumberFormatException e){
					System.out.println("Registro em não conformidade!");	
				}
			}
			linhaLidaDoArquivo = leituraBufferizada.readLine(); 
		}
		fluxoDeLeituraDeArquivoTexto.close();
		return listaDePessoas;
	}

	public void escreverNoArquivo(String caminhoDoArquivo, ColecaoDePessoas listaDePessoas) throws IOException {
		 FileWriter fluxoDeEscritaDeArquivoTexto = new FileWriter(caminhoDoArquivo, false);
		 int totalDePessoas = listaDePessoas.obterTotalDePessoas();
		 Pessoa pessoa = null;
		 for (int numeroDaPessoa = 0; numeroDaPessoa < listaDePessoas.obterTotalDePessoas(); numeroDaPessoa++) {
			 pessoa = listaDePessoas.obterPessoa(numeroDaPessoa);
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterNome() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterDescricao() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterGenero() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterPais() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterOcupacao() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterAnoDeNacimento() + ",");
			 fluxoDeEscritaDeArquivoTexto.write(pessoa.obterAnoDeFalecimento());
			 fluxoDeEscritaDeArquivoTexto.write("\n");			 
		 }
		 fluxoDeEscritaDeArquivoTexto.flush();
		 fluxoDeEscritaDeArquivoTexto.close();
	}
}
