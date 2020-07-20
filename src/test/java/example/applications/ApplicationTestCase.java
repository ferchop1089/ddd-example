package example.applications;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public abstract class ApplicationTestCase {

        @Autowired
        private MockMvc mockMvc;

        // @Autowired
        // private EventBus eventBus;

        protected void assertResponse(String endpoint, Integer expectedStatusCode, String expectedResponse)
                        throws Exception {
                ResultMatcher response = expectedResponse.isEmpty() ? MockMvcResultMatchers.content().string("")
                                : MockMvcResultMatchers.content().json(expectedResponse);

                mockMvc.perform(MockMvcRequestBuilders.get(endpoint))
                                .andExpect(MockMvcResultMatchers.status().is(expectedStatusCode)).andExpect(response);
        }

        protected void assertResponse(String endpoint, Integer expectedStatusCode, String expectedResponse,
                        HttpHeaders headers) throws Exception {
                ResultMatcher response = expectedResponse.isEmpty() ? MockMvcResultMatchers.content().string("")
                                : MockMvcResultMatchers.content().json(expectedResponse);

                mockMvc.perform(MockMvcRequestBuilders.get(endpoint).headers(headers))
                                .andExpect(MockMvcResultMatchers.status().is(expectedStatusCode)).andExpect(response);
        }

        protected void assertRequestWithBody(String method, String endpoint, String body, Integer expectedStatusCode)
                        throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.valueOf(method), endpoint).content(body)
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.status().is(expectedStatusCode))
                                .andExpect(MockMvcResultMatchers.content().string(""));
        }

        protected void assertRequest(String method, String endpoint, Integer expectedStatusCode) throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.valueOf(method), endpoint))
                                .andExpect(MockMvcResultMatchers.status().is(expectedStatusCode))
                                .andExpect(MockMvcResultMatchers.content().string(""));
        }

        /*
         * protected void givenISendEventsToTheBus(DomainEvent... domainEvents) {
         * eventBus.publish(Arrays.asList(domainEvents)); }
         */

}