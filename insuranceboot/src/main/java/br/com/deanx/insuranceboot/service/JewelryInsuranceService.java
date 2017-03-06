package br.com.deanx.insuranceboot.service;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.Insurance;
import br.com.deanx.insuranceboot.model.InsuranceType;

public class JewelryInsuranceService extends InsuranceService {
	private final InsuranceType insuranceType = InsuranceType.JEWELRY;

	@Override
	public Insurance formulateInsuranceProposal(ClientScenario clientScenario) {
		return formulateInsuranceProposal(clientScenario, this.insuranceType);
	}

	@Override
	public boolean isAValidClientScenario(ClientScenario clientScenario) {
		return isAValidClientScenario(clientScenario, this.insuranceType);
	}
}
