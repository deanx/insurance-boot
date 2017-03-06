package br.com.deanx.insuranceboot.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.Insurance;

public class InsuranceService {
	private Locale locale = Locale.GERMANY;
	private Insurance insurance = new Insurance();

	public Insurance formulateInsuranceProposal(ClientScenario clientScenario) {
		BigDecimal insuranceValue = this.calculateInsuranceValue(clientScenario);
		String formattedValue = this.formatValue(insuranceValue);
		this.insurance.setValue(formattedValue);
		return this.insurance;
	}

	private BigDecimal calculateInsuranceValue(ClientScenario clientScenario) {
		BigDecimal insuranceValue = new BigDecimal(clientScenario.getItemType().getRisk() / 1000)
				.multiply(clientScenario.getItemValue());
		return insuranceValue;
	}

	private String formatValue(BigDecimal insuranceValue) {
		String formattedValue = NumberFormat.getCurrencyInstance(locale).format(insuranceValue);
		return formattedValue;
	}
}
