package br.com.deanx.insuranceboot.service;

import br.com.deanx.insuranceboot.model.InsuranceType;

public class InsuranceServiceFactory {
	public InsuranceService getInsuranceService(String productType) {
		if (productType.equals(InsuranceType.BICICLE.toString())) {
			return new BikeInsuranceService();
		}

		if (productType.equals(InsuranceType.JEWELRY.toString())) {
			return new JewelryInsuranceService();
		}

		if (productType.equals(InsuranceType.ELECTRONICS.toString())) {
			return new ElectronicsInsuranceService();
		}

		if (productType.equals(InsuranceType.SPORTS_EQUIPMENT.toString())) {
			return new SportsEquipmentInsuranceService();
		}

		return null;
	}
}
