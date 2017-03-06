package br.com.deanx.insuranceboot.model;

public class InsuranceTypeFactory {
	public InsuranceType getInsuranceType(String productType) {
		if(productType.equals(InsuranceType.BICICLE)) {
			return InsuranceType.BICICLE;
		}
		
		if(productType.equals(InsuranceType.JEWELRY)) {
			return InsuranceType.JEWELRY;
		}
		
		if(productType.equals(InsuranceType.ELECTRONICS)) {
			return InsuranceType.ELECTRONICS;
		}
		
		if(productType.equals(InsuranceType.SPORTS_EQUIPMENT)) {
			return InsuranceType.SPORTS_EQUIPMENT;
		}
		return null;
	}
}
