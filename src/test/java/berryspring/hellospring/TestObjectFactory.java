package berryspring.hellospring;

import berryspring.hellospring.exrate.WebApiExRateProvider;
import berryspring.hellospring.payment.ExRateProvider;
import berryspring.hellospring.payment.ExRateProviderStub;
import berryspring.hellospring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class TestObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }
}
