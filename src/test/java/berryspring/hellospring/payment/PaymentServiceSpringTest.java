package berryspring.hellospring.payment;

import berryspring.hellospring.TestPaymentConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
class PaymentServiceSpringTest {

    @Autowired PaymentService paymentService;
    @Autowired Clock clock;
    @Autowired ExRateProviderStub exRateProviderStub;

    @Test
    void convertedAmount() throws IOException {
        // exRate : 1000
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(1_000));
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(10_000));

        // exRate : 500
        exRateProviderStub.setExRate(BigDecimal.valueOf(500));
        Payment payment2 = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(500));
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(5_000));
    }

    @Test
    void validUntil() throws IOException {
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        Assertions.assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
    }
}