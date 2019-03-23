import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;


public class FetchProductPactTest {

    @Rule
    public PactProviderRuleMk2 mockProvider
            = new PactProviderRuleMk2("productProvider", "localhost", 8080, this);

    @Pact(consumer = "Product pricing")
    public RequestResponsePact getProductsPact(PactDslWithProvider builder) {

        PactDslJsonBody jsonResponse = new PactDslJsonBody()
                .stringMatcher("productName", ".*", "iphoneX")
                .asBody();

        return builder
                .given("get products")
                .uponReceiving("user id")
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
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        HttpRequest httpRequest = requestFactory.buildGetRequest(new GenericUrl("http://localhost:8080/products/1"));
        httpRequest.execute().parseAsString();
    }
}
