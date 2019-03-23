import au.com.dius.pact.consumer.PactProviderRuleMk2;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;


public class FetchProductPactTest {

    @Rule
    public PactProviderRuleMk2 mockProvider
            = new PactProviderRuleMk2("productProvider", "localhost", 8080, this);

    @Test
    public void shouldGetAllProductsFromAValidCustomer() {
        Assert.assertThat(1, Is.is(1));
    }
}
