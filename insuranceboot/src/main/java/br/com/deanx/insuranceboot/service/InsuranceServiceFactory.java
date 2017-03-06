package br.com.deanx.insuranceboot.service;

import br.com.deanx.insuranceboot.model.InsuranceType;

public class InsuranceServiceFactory {
	public InsuranceService getInsuranceService(String productType) {
		if (productType.equals(InsuranceType.BICICLE)) {
			return new BikeInsuranceService();
		}

		if (productType.equals(InsuranceType.JEWELRY)) {
			return new JewelryInsuranceService();
		}

		if (productType.equals(InsuranceType.ELECTRONICS)) {
			return new ElectronicsInsuranceService();
		}

		if (productType.equals(InsuranceType.SPORTS_EQUIPMENT)) {
			return new SportsEquipmentInsuranceService();
		}

		return null;
	}
}
