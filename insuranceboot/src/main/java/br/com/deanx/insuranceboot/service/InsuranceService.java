package br.com.deanx.insuranceboot.service;

import br.com.deanx.insuranceboot.model.Insurance;
import br.com.deanx.insuranceboot.model.InsuranceType;

public interface InsuranceService {
	public Insurance calculateInsurance(InsuranceType typeOfInsurance);
}
