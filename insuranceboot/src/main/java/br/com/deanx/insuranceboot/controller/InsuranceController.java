package br.com.deanx.insuranceboot.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
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
	
	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Insurance calculateInsurance(@RequestBody ClientScenario clientScenario, HttpServletResponse response) {
		
		InsuranceServiceFactory insuranceServiceFactory = new InsuranceServiceFactory();
		String clientItemType = clientScenario.getItemType().toUpperCase();
		
		insuranceService = insuranceServiceFactory.getInsuranceService(clientItemType);
		
		if(!(null != insuranceService && insuranceService.isAValidClientScenario(clientScenario))) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		return insuranceService.formulateInsuranceProposal(clientScenario);
	}
}
