package br.com.deanx.insuranceboot.service;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.InsuranceType;

public class InsuranceServiceFactory {
	public InsuranceService getInsuranceService(ClientScenario clientScenario) {
		if(null == clientScenario || null == clientScenario.getItemType()) {
			throw new IllegalArgumentException();
		}
		
		String itemType = clientScenario.getItemType().toUpperCase();
		
		if (itemType.equals(InsuranceType.BICICLE.toString())) {
			return new BikeInsuranceService();
		}

		if (itemType.equals(InsuranceType.JEWELRY.toString())) {
			return new JewelryInsuranceService();
		}

		if (itemType.equals(InsuranceType.ELECTRONICS.toString())) {
			return new ElectronicsInsuranceService();
		}

		if (itemType.equals(InsuranceType.SPORTS_EQUIPMENT.toString())) {
			return new SportsEquipmentInsuranceService();
		}

		throw new IllegalArgumentException();
	}
}
