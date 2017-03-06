package br.com.deanx.insuranceboot.service;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.Insurance;
import br.com.deanx.insuranceboot.model.InsuranceType;

public class ElectronicsInsuranceService extends InsuranceServiceGeneral implements InsuranceService {
	private final InsuranceType insuranceType = InsuranceType.ELECTRONICS;
	
	@Override
	public Insurance formulateInsuranceProposal(ClientScenario clientScenario) {
		return formulateInsuranceProposal(clientScenario, this.insuranceType);
	}
}
