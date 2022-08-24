import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Busca {

	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	
	public static void leitor(String nome) throws IOException {
		for (int x = 0; x < 10; x++) {
			int lin = 0;
			String path = "D:\\Nova pasta\\Faculdade\\Programação em alto desempenho\\Threads-main\\ExerciciosThreads\\src\\nomescompletos-0"+x+".txt";
			BufferedReader buffRead = new BufferedReader(new FileReader(path));
			String linha = "";
			
			while (linha != null) {
				linha = buffRead.readLine();

					
					if (linha != null && linha.contains(nome) == true) {
						System.out.println("Arquivo: nomescompletos-0"+x+".txt | "+"Linha: "+ lin + " | nome: " + linha);
					}
					lin++;
			}
			buffRead.close();
		}
	}
	public static void leitorConcorrente(String nome) throws Exception {
		List<Thread> threads = new ArrayList<>();
		for (int xx = 0; xx < 10; xx++) {
			final int x = xx;
			Thread t = new Thread(() -> {
					int lin = 0;
					String path = "D:\\Nova pasta\\Faculdade\\Programação em alto desempenho\\Threads-main\\ExerciciosThreads\\src\\nomescompletos-0"+x+".txt";
					BufferedReader buffRead = null;
					try {
						buffRead = new BufferedReader(new FileReader(path));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					String linha = "";
					
					while (linha != null) {
						try {
							linha = buffRead.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	
							
							if (linha != null && linha.contains(nome) == true) {
								System.out.println("Arquivo: nomescompletos-0"+x+".txt | "+"Linha: "+ lin + " | nome: " + linha);
							}
							lin++;
					}
					try {
						buffRead.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			});
			threads.add(t);
			t.start();
			
		}
		for (Thread t: threads) {
			t.join();
		}
	}
	
	public static String lerLinha(String texto) {
		String texto2 = "";
		if (texto != null) {
			for(int y = 0; y < texto.length(); y++) {
				char t = texto.charAt(y);
					if(t == 'A') {
						texto2 += 'T'; 
					}else if (t == 'T') {
						texto2 += 'A'; 
					}else if (t == 'G') {
						texto2 += 'C'; 
					}else if (t == 'C') {
						texto2 += 'G'; 
					}
			}
		}
		return texto2;
	}
	
	public static void leitorDNAConcorrente() throws Exception {
		List<Thread> threads = new ArrayList<>();
			for (int xx = 0; xx < 10; xx++) {
				final int x = xx;
				Thread t = new Thread(() -> {
					String path = "D:\\Nova pasta\\Faculdade\\Programação em alto desempenho\\Threads-main\\ExerciciosThreads\\src\\arquivosDNA\\dna-"+x+".txt";
					BufferedReader buffRead = null;
					try {
						buffRead = new BufferedReader(new FileReader(path));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String linha = "";
					FileWriter arq = null;
					try {
						arq = new FileWriter("D:\\Nova pasta\\Faculdade\\Programação em alto desempenho\\Threads-main\\ExerciciosThreads\\src\\arquivosDNA\\dnaComplementarconcorrente-"+x+".txt");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    PrintWriter gravarArq = new PrintWriter(arq);
					while (linha != null) {
						try {
							linha = buffRead.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String linha2 = lerLinha(linha)+"%n";
						gravarArq.printf(linha2);	
					}
					try {
						arq.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.gc();
					try {
						buffRead.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				threads.add(t);
				t.start();
			}
			for (Thread t: threads) {
				t.join();
			}
		}
		
	
	
	public static void leitorDNA() throws IOException {
		for (int x = 0; x < 10; x++) {
			String path = "D:\\Nova pasta\\Faculdade\\Programação em alto desempenho\\Threads-main\\ExerciciosThreads\\src\\arquivosDNA\\dna-"+x+".txt";
			BufferedReader buffRead = new BufferedReader(new FileReader(path));
			String linha = "";
			FileWriter arq = new FileWriter("D:\\Nova pasta\\Faculdade\\Programação em alto desempenho\\Threads-main\\ExerciciosThreads\\src\\arquivosDNA\\dnaComplementar-"+x+".txt");
		    PrintWriter gravarArq = new PrintWriter(arq);
			while (linha != null) {
				linha = buffRead.readLine();
				String linha2 = lerLinha(linha)+"%n";
				gravarArq.printf(linha2);	
			}
			arq.close();
			System.gc();
			buffRead.close();
		}
		
	}
}
