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

    private static final String PATH = "/products/1";

    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("productProvider", "localhost", 8080, this);

    @Pact(consumer = "consumerA")
    public RequestResponsePact getProducts(PactDslWithProvider builder) {
        PactDslJsonBody jsonResponse = new PactDslJsonBody()
                .stringMatcher("name", ".*", "iphoneX")
                .asBody();

        return builder.uponReceiving("get products")
                .path(PATH)
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(jsonResponse)
                .toPact();
    }

    @Test
    @PactVerification(fragment = "getProducts")
    public void shouldFetchProducts() throws IOException {
        RestService.get("/products/1");
    }

}
