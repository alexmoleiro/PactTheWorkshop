package infrastructure;

import application.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public class RestService {

    public static Product get(String path, Class<Product> valueType, String server) throws IOException {
        HttpRequestFactory request = new NetHttpTransport().createRequestFactory();
        HttpRequest httpRequest = request.buildGetRequest(new GenericUrl(server + path));
        return new ObjectMapper().readValue(httpRequest.execute().parseAsString(), valueType);
    }
}
