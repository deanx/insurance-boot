package br.com.deanx.insuranceboot.model;

import java.math.BigDecimal;

public class ClientScenario {
	private BigDecimal itemValue;
	private String itemType;
	
	public BigDecimal getItemValue() {
		return itemValue;
	}
	public void setItemValue(BigDecimal itemValue) {
		this.itemValue = itemValue;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}	
}
