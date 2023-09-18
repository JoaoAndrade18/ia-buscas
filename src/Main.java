import espacoDeEstados.*;
import estrategiasDeBusca.cega.*;
import estrategiasDeBusca.heuristica.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		// Variaveis de configuracao do puzzle	
		// Scanner input = new Scanner(System.in);
		char[] cfgIni;
		char[] cfgEnd;

		// Gerador de numeros aleatorios
		// Random random = new Random();		
		
		// int numeroAleatorio3 = random.nextInt(3) +1;

		cfgIni = new char[]{'1','2','3','4',' ','5','6','7','8'}; 
		cfgEnd = new char[]{'1','2','3','4','5','6','7','8',' '};


		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado( cfgIni );
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( cfgEnd );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
			
		
		// Modelo de busca a ser utilizado para resolver o problema

        // BuscaCega busca = null;

        // if (numeroAleatorio3 == 1) {
		// 	System.out.println("Busca em Largura selecionada");
        //     busca = new BuscaEmLargura();
        // } else if (numeroAleatorio3 == 2) {
		// 	System.out.println("Busca em Profundidade selecionada"); // Out of memory
        //     busca = new BuscaEmProfundidade();
        // } else {
		// 	System.out.println("Busca em Profundidade Limitada selecionada, informe o limite:"); // acima de 13 para funcionar
		// 	int limite = input.nextInt();
		// 	System.out.println("Limite informado: " + limite);
        //     busca = new BuscaEmProfundidadeLimitada(null, null, limite);
		// 	input.close();
        // } 

		// BuscaCega busca = new BuscaEmLargura();
		BuscaCega busca = new BuscaEmProfundidade(); // Não presta !!!!!!!!!!!!!!
		// BuscaCega busca = new BuscaEmProfundidadeLimitada(null, null, 14);

		// BuscaInformada busca = new AStar();
		// BuscaInformada busca = new HillClimbing();
		// BuscaInformada busca = new BestFirst();

		busca.setInicio(puzzleInicial);
		busca.setObjetivo(puzzleFinal);
		busca.buscar();
		for(Estado e : busca.getCaminhoSolucao()) {
			System.out.println("\n" + e);
		}

		System.exit(0);
	}

}
