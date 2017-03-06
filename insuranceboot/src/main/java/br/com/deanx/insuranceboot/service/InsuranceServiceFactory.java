package br.com.deanx.insuranceboot.service;

import br.com.deanx.insuranceboot.model.InsuranceType;

public class InsuranceServiceFactory {
	public InsuranceService getInsuranceService(InsuranceType typeOfInsurance) {
		if (typeOfInsurance.toString().equals(InsuranceType.BICICLE)) {
			return new BikeInsuranceService();
		}

		if (typeOfInsurance.toString().equals(InsuranceType.JEWELRY)) {
			return new JewelryInsuranceService();
		}

		if (typeOfInsurance.toString().equals(InsuranceType.ELECTRONICS)) {
			return new ElectronicsInsuranceService();
		}

		if (typeOfInsurance.toString().equals(InsuranceType.SPORTS_EQUIPMENT)) {
			return new SportsEquipmentInsuranceService();
		}

		return null;
	}
}
