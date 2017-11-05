package com.skp.rnd;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Skpandey
 *
 */
@RestController
@RequestMapping("/api")
public class SimpleRestController {

	// Logger instance
	private static final Logger logger = Logger.getLogger(SimpleRestController.class);

	@RequestMapping(value = "/fullname", method = RequestMethod.GET)
	public String getFullName(@RequestParam(value = "request") String request,	@RequestParam(value = "version", required = false, defaultValue = "1") int version) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Start getSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1");
				response = "Response from Spring RESTful Webservice : "+ request+" Kumar Pandey";

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			response = e.getMessage().toString();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: " + response);
			logger.debug("End getSomething");
		}
		return response;
	}

}
