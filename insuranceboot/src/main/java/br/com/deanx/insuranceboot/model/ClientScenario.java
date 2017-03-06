package br.com.deanx.insuranceboot.model;

import java.math.BigDecimal;

public class ClientScenario {
	private BigDecimal itemValue;
	private InsuranceType itemType;

	public void validate() {
		if (!(isValidMinScenarioValue() && isValidMaxScenarioValue())) {
			throw new IllegalArgumentException();
		}
	}

	public BigDecimal getItemValue() {
		return itemValue;
	}

	public void setItemValue(BigDecimal itemValue) {
		this.itemValue = itemValue;
	}

	public InsuranceType getItemType() {
		return itemType;
	}

	public void setItemType(InsuranceType itemType) {
		this.itemType = itemType;
	}

	private boolean isValidMinScenarioValue() {
		return itemValue.compareTo(itemType.getMinValue()) >= 0;
	}

	private boolean isValidMaxScenarioValue() {
		return itemValue.compareTo(itemType.getMaxValue()) <= 0;
	}
}
