import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class IO_NIO {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().dynamicPort());

    private String REQUESTED_RESOURCE = "/test.json";

    @Before
    public void setup() {
        stubFor(get(urlEqualTo(REQUESTED_RESOURCE))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("{ \"response\" : \"It worked!\" }")));
    }
}
