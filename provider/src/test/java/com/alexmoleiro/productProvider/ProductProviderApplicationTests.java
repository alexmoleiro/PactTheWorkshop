package com.alexmoleiro.productProvider;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import com.alexmoleiro.productProvider.controller.ProductController;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(RestPactRunner.class)
@Provider("productoProvider")
@PactFolder("pacts")
public class ProductProviderApplicationTests {

	@TestTarget
	public final MockMvcTarget target = new MockMvcTarget();

	@Before
	public void setup() {

		ProductController productController = new ProductController();
		target.setControllers(productController);

	}

	@State("user id")
	public void verifiesPact() {
		target.setRunTimes(1);
	}

}
