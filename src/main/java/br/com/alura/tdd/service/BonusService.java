package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	//CLASSE QUE SER� REALIZADO OS TESTES
	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcin�rio com salario maior que $10.000 n�o pode te bonus");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
