package com.alexmoleiro.productProvider;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import com.alexmoleiro.productProvider.controller.ProductController;
import org.junit.Before;
import org.junit.runner.RunWith;


import java.util.Properties;

@RunWith(RestPactRunner.class)
@Provider("productProvider")
@PactBroker(host = "localhost", port = "8000", tags = {"latest"})

public class ProductProviderApplicationTests {

	@TestTarget
	public final MockMvcTarget target = new MockMvcTarget();

	@Before
	public void setup() {

		ProductController productController = new ProductController();
		target.setControllers(productController);
    
		sendVerificationToTheBroker();

	}

	public void verifiesPact() {
		target.setRunTimes(1);
	}

	private void sendVerificationToTheBroker() {
		Properties prop = System.getProperties();
		prop.put("pact.verifier.publishResults", "true");
		System.setProperties(prop);
	}
}
