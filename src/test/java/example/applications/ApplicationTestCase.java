package example.applications;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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

        protected void assertResponse(HttpMethod method, String endpoint, String expectedResponse,
                        HttpStatus expectedStatusCode) throws Exception {
                ResultMatcher response = expectedResponse.isEmpty() ? MockMvcResultMatchers.content().string("")
                                : MockMvcResultMatchers.content().json(expectedResponse);

                mockMvc.perform(MockMvcRequestBuilders.request(method, endpoint))
                                .andExpect(MockMvcResultMatchers.status().is(expectedStatusCode.value()))
                                .andExpect(response);
        }

        protected void assertResponse(HttpMethod method, String endpoint, String expectedResponse, HttpHeaders headers,
                        HttpStatus expectedStatusCode) throws Exception {
                ResultMatcher response = expectedResponse.isEmpty() ? MockMvcResultMatchers.content().string("")
                                : MockMvcResultMatchers.content().json(expectedResponse);

                mockMvc.perform(MockMvcRequestBuilders.request(method, endpoint).headers(headers))
                                .andExpect(MockMvcResultMatchers.status().is(expectedStatusCode.value()))
                                .andExpect(response);
        }

        protected void assertRequestWithBody(HttpMethod method, String endpoint, String body,
                        HttpStatus expectedStatusCode) throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.request(method, endpoint).content(body)
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.status().is(expectedStatusCode.value()))
                                .andExpect(MockMvcResultMatchers.content().string(""));
        }

        protected void assertRequest(HttpMethod method, String endpoint, HttpStatus expectedStatusCode)
                        throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.request(method, endpoint))
                                .andExpect(MockMvcResultMatchers.status().is(expectedStatusCode.value()))
                                .andExpect(MockMvcResultMatchers.content().string(""));
        }

        /*
         * protected void givenISendEventsToTheBus(DomainEvent... domainEvents) {
         * eventBus.publish(Arrays.asList(domainEvents)); }
         */

}