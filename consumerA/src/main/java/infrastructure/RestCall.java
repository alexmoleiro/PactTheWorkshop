package infrastructure;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public class RestCall {
    public static String getProducts() throws IOException {
        HttpRequestFactory request = new NetHttpTransport().createRequestFactory();
        String encodedUrl = "http://localhost:8080/products/1";
        GenericUrl providerUrl = new GenericUrl(encodedUrl);
        HttpRequest httpRequest = request.buildGetRequest(providerUrl);
        return httpRequest.execute().parseAsString();
    }
}
