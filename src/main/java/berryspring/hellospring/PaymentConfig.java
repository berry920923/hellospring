package berryspring.hellospring;

import berryspring.hellospring.api.ApiTemplate;
import berryspring.hellospring.api.ErApiExtractor;
import berryspring.hellospring.api.SimpleApiExecutor;
import berryspring.hellospring.payment.ExRateProvider;
import berryspring.hellospring.exrate.WebApiExRateProvider;
import berryspring.hellospring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ApiTemplate apiTemplate() {
        return new ApiTemplate(new SimpleApiExecutor(), new ErApiExtractor());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider(apiTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
