package br.com.deanx.insuranceboot.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.Insurance;
import br.com.deanx.insuranceboot.model.InsuranceType;
import br.com.deanx.insuranceboot.model.InsuranceTypeFactory;

public class InsuranceServiceGeneral {
	private Locale locale = Locale.GERMANY;
	protected Insurance insurance = new Insurance();

	public void validateClientScenario(ClientScenario clientScenario) {
		try {
			InsuranceTypeFactory insuranceTypeFactory = new InsuranceTypeFactory();
			String itemType = clientScenario.getItemType();
			InsuranceType insuranceType = insuranceTypeFactory.getInsuranceType(itemType.toUpperCase());

			if (!(isValidMinScenarioValue(clientScenario, insuranceType) 
					&& isValidMaxScenarioValue(clientScenario, insuranceType))) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	protected Insurance formulateInsuranceProposal(ClientScenario clientScenario, InsuranceType insuranceType) {
		BigDecimal insuranceValue = this.calculateInsuranceValue(clientScenario, insuranceType);
		String formattedValue = this.getFormatedValue(insuranceValue);
		this.insurance.setValue(formattedValue);
		return this.insurance;
	}

	private BigDecimal calculateInsuranceValue(ClientScenario clientScenario, InsuranceType insuranceType) {
		BigDecimal insuranceValue = new BigDecimal(insuranceType.getRisk() / 1000)
				.multiply(clientScenario.getItemValue());
		return insuranceValue;
	}

	private String getFormatedValue(BigDecimal insuranceValue) {
		String formattedValue = NumberFormat.getCurrencyInstance(locale).format(insuranceValue);
		return formattedValue;
	}
	
	private boolean isValidMinScenarioValue(ClientScenario clientScenario, InsuranceType insuranceType) {
		return clientScenario.getItemValue().compareTo(insuranceType.getMinValue()) >= 0;
	}
	
	private boolean isValidMaxScenarioValue(ClientScenario clientScenario, InsuranceType insuranceType) {
		return clientScenario.getItemValue().compareTo(insuranceType.getMaxValue()) <= 0;
	}
}
