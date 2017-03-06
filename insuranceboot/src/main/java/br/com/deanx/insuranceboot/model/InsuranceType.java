package br.com.deanx.insuranceboot.model;

import java.math.BigDecimal;

public enum InsuranceType {
	BICICLE {
		public Double getRisk() {
			return 30.0;
		};

		public BigDecimal getMinValue() {
			return new BigDecimal(0.0);
		};

		public BigDecimal getMaxValue() {
			return new BigDecimal(3_000.0);
		}
	},
	JEWELRY {
		public Double getRisk() {
			return 5.0;
		};

		public BigDecimal getMinValue() {
			return new BigDecimal(500.0);
		};

		public BigDecimal getMaxValue() {
			return new BigDecimal(10_000.0);
		}
	},
	ELECTRONICS {
		public Double getRisk() {
			return 35.0;
		};

		public BigDecimal getMinValue() {
			return new BigDecimal(500.0);
		};

		public BigDecimal getMaxValue() {
			return new BigDecimal(6_000.0);
		}
	},
	SPORTS_EQUIPMENT{
		public Double getRisk() {
			return 30.0;
		};
		public BigDecimal getMinValue() {
			return new BigDecimal(0.0);
		};
		public BigDecimal getMaxValue() {
			return new BigDecimal(20_000.0);
		}
	};

	private Double risk;
	private BigDecimal minValue;
	private BigDecimal maxValue;
	
	public Double getRisk() {
		return this.risk;
	}
	
	public BigDecimal getMinValue() {
		return this.minValue;
	}
	
	public BigDecimal getMaxValue() {
		return this.maxValue;
	}
}
