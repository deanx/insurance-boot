package br.com.deanx.insuranceboot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.InsuranceType;

public class InsuranceServiceTest {

	private static InsuranceService insuranceService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		insuranceService = new InsuranceService();
	}

	@Test
	public void formulateInsuranceForBicicle() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType(InsuranceType.BICICLE);
		clientScenario.setItemValue(new BigDecimal(30));

		assertEquals("0,90 €", insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}

	@Test
	public void formulateInsuranceForJewelry() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType(InsuranceType.JEWELRY);
		clientScenario.setItemValue(new BigDecimal(1_000));

		assertEquals("5,00 €", insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}

	@Test
	public void formulateInsuranceForElectronics() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType(InsuranceType.ELECTRONICS);
		clientScenario.setItemValue(new BigDecimal(1200));

		assertEquals("42,00 €", insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}

	@Test
	public void formulateInsuranceForSportsEquipment() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType(InsuranceType.SPORTS_EQUIPMENT);
		clientScenario.setItemValue(new BigDecimal(10000));

		assertEquals("300,00 €", insuranceService.formulateInsuranceProposal(clientScenario).getValue());
	}

	@Test
	public void validateScenarioForCorrectClientScenario() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType(InsuranceType.BICICLE);
		clientScenario.setItemValue(new BigDecimal(30));

		try {
			clientScenario.validate();
		} catch (IllegalArgumentException e) {
			assertNull(e);
		}
	}

	@Test
	public void validateScenarioForLowValue() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType(InsuranceType.JEWELRY);
		clientScenario.setItemValue(new BigDecimal(30));

		try {
			clientScenario.validate();
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
		}
	}

	@Test
	public void validateScenarioForHighValue() {
		ClientScenario clientScenario = new ClientScenario();
		clientScenario.setItemType(InsuranceType.ELECTRONICS);
		clientScenario.setItemValue(new BigDecimal(300000));

		try {
			clientScenario.validate();
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
		}

	}

}
