package berryspring.hellospring;

import berryspring.hellospring.api.ApiTemplate;
import berryspring.hellospring.api.ErApiExtractor;
import berryspring.hellospring.api.SimpleApiExecutor;
import berryspring.hellospring.exrate.RestTemplateExRateProvider;
import berryspring.hellospring.payment.ExRateProvider;
import berryspring.hellospring.exrate.WebApiExRateProvider;
import berryspring.hellospring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new JdkClientHttpRequestFactory());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new RestTemplateExRateProvider(restTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
