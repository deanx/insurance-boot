package br.com.deanx.insuranceboot.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.deanx.insuranceboot.model.ClientScenario;
import br.com.deanx.insuranceboot.model.Insurance;
import br.com.deanx.insuranceboot.service.InsuranceService;
import br.com.deanx.insuranceboot.service.InsuranceServiceFactory;

@RestController
public class InsuranceController {
	private InsuranceService insuranceService = null;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Insurance calculateInsurance(@RequestBody ClientScenario clientScenario, HttpServletResponse response) {
		try {
			InsuranceServiceFactory insuranceServiceFactory = new InsuranceServiceFactory();
			String clientItemType = clientScenario.getItemType();

			insuranceService = insuranceServiceFactory.getInsuranceService(clientItemType);

			if (!insuranceService.isAValidClientScenario(clientScenario)) {
				throw new IllegalArgumentException();
			}

			return insuranceService.formulateInsuranceProposal(clientScenario);

		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
}
