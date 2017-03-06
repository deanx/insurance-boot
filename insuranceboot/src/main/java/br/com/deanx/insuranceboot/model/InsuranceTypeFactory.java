package br.com.deanx.insuranceboot.model;

public class InsuranceTypeFactory {
	public InsuranceType getInsuranceType(String productType) {
		if(productType.equals(InsuranceType.BICICLE.toString())) {
			return InsuranceType.BICICLE;
		}
		
		if(productType.equals(InsuranceType.JEWELRY.toString())) {
			return InsuranceType.JEWELRY;
		}
		
		if(productType.equals(InsuranceType.ELECTRONICS.toString())) {
			return InsuranceType.ELECTRONICS;
		}
		
		if(productType.equals(InsuranceType.SPORTS_EQUIPMENT.toString())) {
			return InsuranceType.SPORTS_EQUIPMENT;
		}
		
		throw new IllegalArgumentException();
	}
}
