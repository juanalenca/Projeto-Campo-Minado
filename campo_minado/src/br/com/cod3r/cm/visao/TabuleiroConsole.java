package br.com.cod3r.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.cod3r.cm.excecao.ExplosaoException;
import br.com.cod3r.cm.excecao.SairException;
import br.com.cod3r.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	Scanner scan = new Scanner(System.in);

	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	
	
	private void executarJogo() {
		try {
			
			boolean continuar = true;
			
			while (continuar) {
				
				cicloDoJogo();
				
				System.out.println("Outra partida? (S/n)");
				String resposta = scan.nextLine();
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
			
			}
			
		} catch (Exception e) {
			System.out.println("Goodbye!");
		} finally {
			scan.close();
		}
	}


	private void cicloDoJogo() {
		try {
			
			while(!tabuleiro.objetivoAlcancado()) {
			
				System.out.println(tabuleiro);
				
				String digitado = capturarVAlorDigitado("Digite (x, y): ");;
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
					.map(e -> Integer.parseInt(e.trim())).iterator();
				
				digitado = capturarVAlorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");

				if("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				} else if("2".equals(digitado)) {
					tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
				
			}
			
			System.out.println(tabuleiro);
			System.out.println("MISSION PASSED\nRESPECT +");
		
		} catch (ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("\nSE FODEU");
		}
	}
	
	
	private String capturarVAlorDigitado(String texto) { 
		
		System.out.print(texto);
		String digitado = scan.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		
		return digitado;
		
	}
	
	
	
}
