package berryspring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExrateProvider {
    BigDecimal getExRate(String currency) throws IOException {
        if(currency.equals("USD")) return BigDecimal.valueOf(1000);
        throw new IllegalArgumentException("사용하지 않는 통화입니다.");
    }
}
