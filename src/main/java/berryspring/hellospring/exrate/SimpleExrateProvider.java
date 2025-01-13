package berryspring.hellospring.exrate;

import berryspring.hellospring.payment.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExrateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) {
        if(currency.equals("USD")) return BigDecimal.valueOf(1000);
        throw new IllegalArgumentException("사용하지 않는 통화입니다.");
    }
}
