package br.com.deanx.insuranceboot.service;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.Insurance;
import br.com.deanx.insuranceboot.model.InsuranceType;

public class SportsEquipmentInsuranceService  extends InsuranceService {
	private final InsuranceType insuranceType = InsuranceType.SPORTS_EQUIPMENT;
	
	@Override
	public Insurance calculateInsurance(ClientScenario clientScenario) {
		return calculateInsurance(clientScenario, this.insuranceType);
	}
}
