package br.com.deanx.insuranceboot.service;

import java.math.BigDecimal;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.Insurance;
import br.com.deanx.insuranceboot.model.InsuranceType;

public abstract class InsuranceService {
	public abstract Insurance calculateInsurance(ClientScenario clientScenario);
	
	public Insurance calculateInsuranceValue(ClientScenario clientScenario, InsuranceType insuranceType) {
		Insurance insuranceProposal = new Insurance();
		BigDecimal insuranceValue = new BigDecimal(insuranceType.getRisk() / 100).multiply(clientScenario.getItemValue());
		insuranceProposal.setValue(insuranceValue);
		return insuranceProposal;
	}
}
