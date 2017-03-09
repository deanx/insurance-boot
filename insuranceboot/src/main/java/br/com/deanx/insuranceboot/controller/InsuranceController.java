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

@RestController
public class InsuranceController {
	private InsuranceService insuranceService = new InsuranceService();

	@CrossOrigin(origins="http://localhost:3000",methods=RequestMethod.POST)
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Insurance calculateInsurance(@RequestBody ClientScenario clientScenario, HttpServletResponse response) {
		try {
			clientScenario.validate();
			return insuranceService.formulateInsuranceProposal(clientScenario);

		} catch (IllegalArgumentException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
}
