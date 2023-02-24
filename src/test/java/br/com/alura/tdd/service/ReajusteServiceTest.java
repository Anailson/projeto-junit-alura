package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

/**
 * 
 * @author anailson - regra do teste
 * O sistema deve permitir que os funcion�rios recebam um reajuste salarial anual
 *  baseado em seu desempenho, obedecendo �s seguintes regras:
Se o desempenho for classificado como "A desejar", o reajuste ser� de 3% do sal�rio atual.
Se o desempenho for "Bom,", o reajuste ser� de 15% do sal�rio.
Se o desempenho for "�timo", o reajuste ser� de 20% do sal�rio.
 *
 */
public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach//antes de cada metodo � chamado o metodo
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
		
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("fim");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("ANTES DE TODOS");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("DEPOIS DE TODOS");
	}
	
	
	@Test
	public void reajusteDeveriaSerDeTresPorCentroDesempenhoADesejar() {
	
		service.concederReajuste(funcionario, Desempenho.A_Desejar);		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void desempenhoBom() {
	
	
		service.concederReajuste(funcionario, Desempenho.A_Bom);		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
		
	}
	@Test
	public void desempenhoOtimo() {
			
	
		service.concederReajuste(funcionario, Desempenho.A_Otimo);		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
		
	}

}
