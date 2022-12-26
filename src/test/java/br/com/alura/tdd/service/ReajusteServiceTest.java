package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

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
	
	@Test
	public void reajusteDeveriaSerDeTresPorCentroDesempenhoADesejar() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
		
		service.concederReajuste(funcionario, Desempenho.A_Desejar);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void desempenhoBom() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
		
		service.concederReajuste(funcionario, Desempenho.A_Bom);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
		
	}
	@Test
	public void desempenhoOtimo() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
		
		service.concederReajuste(funcionario, Desempenho.A_Otimo);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
		
	}

}
