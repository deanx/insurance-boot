package br.com.deanx.insuranceboot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.deanx.insuranceboot.model.ClientScenario;

public class InsuranceServiceTest {

	private static InsuranceServiceFactory insuranceServiceFactory;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		insuranceServiceFactory = new InsuranceServiceFactory();
	}
	@Test
	public void formulateInsuranceForBicicle() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("BICICLE");
		clientScenario.setItemValue(new BigDecimal(30));
		
		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario.getItemType());
		assertEquals("9,00 €",insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}

	@Test
	public void formulateInsuranceForJewelry() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("JEWELRY");
		clientScenario.setItemValue(new BigDecimal(1_000));
		
		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario.getItemType());
		assertEquals("50,00 €",insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}
	
	@Test
	public void formulateInsuranceForElectronics() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("ELECTRONICS");
		clientScenario.setItemValue(new BigDecimal(1200));
		
		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario.getItemType());
		assertEquals("420,00 €",insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}
	
	@Test
	public void formulateInsuranceForSportsEquipment() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("SPORTS_EQUIPMENT");
		clientScenario.setItemValue(new BigDecimal(10000));
		
		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario.getItemType());
		assertEquals("3.000,00 €",insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}
	
	
	@Test
	public void validateScenarioForCorrectClientScenario() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("BICICLE");
		clientScenario.setItemValue(new BigDecimal(30));
		
		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario.getItemType());
		
		assertTrue(insuranceService.isAValidClientScenario(clientScenario));
	}
	
	@Test
	public void validateScenarioForLowValue() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("JEWELRY");
		clientScenario.setItemValue(new BigDecimal(30));
		
		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario.getItemType());
		
		assertFalse(insuranceService.isAValidClientScenario(clientScenario));
	}

	@Test
	public void validateScenarioForHighValue() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("BICICLE");
		clientScenario.setItemValue(new BigDecimal(300000));
		
		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario.getItemType());
		
		assertFalse(insuranceService.isAValidClientScenario(clientScenario));
	}
	
	
}
