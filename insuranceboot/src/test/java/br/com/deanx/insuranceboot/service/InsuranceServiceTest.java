package br.com.deanx.insuranceboot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario);
		assertEquals("0,90 €", insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}

	@Test
	public void formulateInsuranceForJewelry() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("JEWELRY");
		clientScenario.setItemValue(new BigDecimal(1_000));

		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario);
		assertEquals("5,00 €", insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}

	@Test
	public void formulateInsuranceForElectronics() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("ELECTRONICS");
		clientScenario.setItemValue(new BigDecimal(1200));

		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario);
		assertEquals("42,00 €", insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}

	@Test
	public void formulateInsuranceForSportsEquipment() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("SPORTS_EQUIPMENT");
		clientScenario.setItemValue(new BigDecimal(10000));

		InsuranceService insuranceService = insuranceServiceFactory.getInsuranceService(clientScenario);
		assertEquals("300,00 €", insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}

	@Test
	public void validateScenarioForCorrectClientScenario() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("BICICLE");
		clientScenario.setItemValue(new BigDecimal(30));

		try {
			new InsuranceServiceGeneral().validateClientScenario(clientScenario);
		} catch (IllegalArgumentException e) {
			assertNull(e);
		}
	}

	@Test
	public void validateScenarioForLowValue() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("JEWELRY");
		clientScenario.setItemValue(new BigDecimal(30));

		try {
			new InsuranceServiceGeneral().validateClientScenario(clientScenario);
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
		}
	}

	@Test
	public void validateScenarioForHighValue() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType("BICICLE");
		clientScenario.setItemValue(new BigDecimal(300000));

		try {
			new InsuranceServiceGeneral().validateClientScenario(clientScenario);
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
		}

	}

}
