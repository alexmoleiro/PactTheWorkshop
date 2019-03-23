package com.alexmoleiro.productProvider;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(SpringRestPactRunner.class)
@RunWith(SpringRestPactRunner.class)
@Provider("productListProvider")
@PactFolder("pacts")
public class ProductProviderApplicationTests {

	@Test
	public void verifiesPact() {
	}

}
