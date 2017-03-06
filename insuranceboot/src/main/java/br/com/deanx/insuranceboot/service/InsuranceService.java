package br.com.deanx.insuranceboot.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.Insurance;
import br.com.deanx.insuranceboot.model.InsuranceType;

public abstract class InsuranceService {
	private Locale locale = Locale.GERMANY;
	protected Insurance insurance = new Insurance();
	
	public abstract Insurance calculateInsurance(ClientScenario clientScenario);
	
	public Insurance calculateInsurance(ClientScenario clientScenario, InsuranceType insuranceType) {
		BigDecimal insuranceValue = this.calculateInsuranceValue(clientScenario, insuranceType);
		String formattedValue = this.getFormatedValue(insuranceValue);
		this.insurance.setValue(formattedValue);
		return this.insurance;
	}
	
	BigDecimal calculateInsuranceValue(ClientScenario clientScenario, InsuranceType insuranceType) {
		BigDecimal insuranceValue = new BigDecimal(insuranceType.getRisk() / 100).multiply(clientScenario.getItemValue());
		return insuranceValue;
	}
	
	String getFormatedValue(BigDecimal insuranceValue) {
		String formattedValue = NumberFormat.getCurrencyInstance(locale).format(insuranceValue);
		return formattedValue;
	}
	
}
