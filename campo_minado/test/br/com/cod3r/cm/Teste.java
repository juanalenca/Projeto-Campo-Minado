package br.com.cod3r.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {

	//é obrigatório o @Test antes da declaração da função para que ela seja testada
	
	@Test
	void testarSeIgualADois() {
		int a = 1+ 1;
		
		assertEquals(2, a);
	}
	
	@Test
	void testarSeIgualATres() {
		int x = 2 + 10 - 9;
		
		assertEquals(3, x);
	}

}