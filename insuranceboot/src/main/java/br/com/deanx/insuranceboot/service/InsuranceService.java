package br.com.deanx.insuranceboot.service;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.Insurance;

public interface InsuranceService {

	public Insurance formulateInsuranceProposal(ClientScenario clientScenario);
}
