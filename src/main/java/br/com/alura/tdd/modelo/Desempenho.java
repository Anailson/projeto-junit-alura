package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
	A_Desejar {
		@Override
		public BigDecimal percentutalReajuste() {
		
			return new BigDecimal(("0.03"));
		}
	}, 
	A_Bom {
		@Override
		public BigDecimal percentutalReajuste() {
		
			return new BigDecimal(("0.15"));
		}
	},
	A_Otimo {
		@Override
		public BigDecimal percentutalReajuste() {
			
			return new BigDecimal(("0.20"));
		}
	};
	
	public abstract BigDecimal percentutalReajuste();

}
