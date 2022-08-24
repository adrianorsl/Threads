 
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Busca teste = new Busca();
		Scanner sc = new Scanner(System.in);
		String nome = sc.nextLine();
		long[] seqNome = new long[10];
		// Busca de nomes sequencial
		for (int x = 0; x < 10; x++) {
			long tempoInicial = System.currentTimeMillis();
			Busca.leitor(nome);
			long tempoFinal = System.currentTimeMillis();
			seqNome[x] = (tempoFinal - tempoInicial);
			
		}
		// Busca de nomes concorrente
		long[] concorrenteNome = new long[10];
		for (int x = 0; x < 10; x++) {
			long tempoInicial2 = System.currentTimeMillis();
			try {
				Busca.leitorConcorrente(nome);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long tempoFinal2 = System.currentTimeMillis();
			concorrenteNome[x] = (tempoFinal2 - tempoInicial2);
		}
		
		// DNA sequencial
		long[] seqDNA = new long[10];
		for (int x = 0; x < 10; x++) {
			long tempoInicialDna = System.currentTimeMillis();
			Busca.leitorDNA();
			long tempoFinalDna = System.currentTimeMillis();
			seqDNA[x] = (tempoFinalDna - tempoInicialDna);
		}
		
		//DNA concorrente
		long[] concorrenteDNA = new long[10];
		for (int x = 0; x < 10; x++) {
			long tempoInicialDnaConcorrente = System.currentTimeMillis();
			try {
				Busca.leitorDNAConcorrente();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long tempoFinalDnaConcorrente = System.currentTimeMillis();
			concorrenteDNA[x] = (tempoFinalDnaConcorrente - tempoInicialDnaConcorrente);
		}
		
		for (int x = 0; x < seqNome.length; x++) {
			System.out.println("o metodo seguencial executou em: " + seqNome[x]);
		}
		for (int x = 0; x < concorrenteNome.length; x++) {
			System.out.println("o metodo concorrente executou em: " + concorrenteNome[x]);
		}
		for (int x = 0; x < seqDNA.length; x++) {
			System.out.println("o metodo seguencial executou em: " + seqDNA[x]);
		}
		for (int x = 0; x < concorrenteDNA.length; x++) {
			System.out.println("o metodo concorrente executou em: " + concorrenteDNA[x]);
		}
	}

}
