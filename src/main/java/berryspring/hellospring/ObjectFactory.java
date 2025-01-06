package berryspring.hellospring;

import berryspring.hellospring.exrate.CachedExRateProvider;
import berryspring.hellospring.payment.ExRateProvider;
import berryspring.hellospring.exrate.WebApiExRateProvider;
import berryspring.hellospring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
