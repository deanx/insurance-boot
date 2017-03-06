package br.com.deanx.insuranceboot.service;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.Insurance;
import br.com.deanx.insuranceboot.model.InsuranceType;

public class JewelryInsuranceService extends InsuranceService {
	private final InsuranceType insuranceType = InsuranceType.JEWELRY;
	
	@Override
	public Insurance calculateInsurance(ClientScenario clientScenario) {
		return this.calculateInsuranceValue(clientScenario, insuranceType);
	}

}
