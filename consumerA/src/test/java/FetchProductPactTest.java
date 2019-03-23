import application.Product;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import infrastructure.RestService;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;


public class FetchProductPactTest {

    @Rule
    public PactProviderRuleMk2 mockProvider
            = new PactProviderRuleMk2("productListProvider", "localhost", 8080, this);

    @Pact(consumer = "consumerA")
    public RequestResponsePact getProductsPact(PactDslWithProvider builder) {

        PactDslJsonBody jsonResponse = new PactDslJsonBody()
                .stringMatcher("productName", ".*", "iphoneX")
                .asBody();

        return builder
                .given("user id")
                    .uponReceiving("get products")
                 .path("/products/1")
                    .method("GET")
                .willRespondWith()
                    .status(200)
                    .body(jsonResponse)
                .toPact();

    }


    @Test
    @PactVerification(fragment = "getProductsPact")
    public void shouldFetchProducts() throws IOException {

        String localhost = "http://localhost:8080";
        String path = "/products/1";
        RestService.get(path, Product.class, localhost);

    }


}
