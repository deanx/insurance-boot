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
	
	public abstract Insurance formulateInsuranceProposal(ClientScenario clientScenario);
	public abstract boolean isAValidClientScenario(ClientScenario clientScenario);
	
	Insurance formulateInsuranceProposal(ClientScenario clientScenario, InsuranceType insuranceType) {
		BigDecimal insuranceValue = this.calculateInsuranceValue(clientScenario, insuranceType);
		String formattedValue = this.getFormatedValue(insuranceValue);
		this.insurance.setValue(formattedValue);
		return this.insurance;
	}
	
	boolean isAValidClientScenario(ClientScenario clientScenario, InsuranceType insuranceType) {
		return (clientScenario.getItemValue().compareTo(insuranceType.getMinValue()) >= 0
				&& clientScenario.getItemValue().compareTo(insuranceType.getMaxValue()) <= 0);
	}
	
	private BigDecimal calculateInsuranceValue(ClientScenario clientScenario, InsuranceType insuranceType) {
		BigDecimal insuranceValue = new BigDecimal(insuranceType.getRisk() / 100).multiply(clientScenario.getItemValue());
		return insuranceValue;
	}
	
	private String getFormatedValue(BigDecimal insuranceValue) {
		String formattedValue = NumberFormat.getCurrencyInstance(locale).format(insuranceValue);
		return formattedValue;
	}
}
