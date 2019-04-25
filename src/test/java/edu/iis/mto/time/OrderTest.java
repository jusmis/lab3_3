package edu.iis.mto.time;

import org.junit.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;

public class OrderTest {
    
    @Test(expected = OrderExpiredException.class)
    public void shouldThrowOrderExpiredExceptionAfterOrderHasExpired(){

        final int OVER_VALID_PERIOD_HOURS = 25;

        Clock systemClock = Clock.system(ZoneId.systemDefault());
        Order order = new Order(Clock.offset(systemClock, Duration.ofHours(-OVER_VALID_PERIOD_HOURS)));
        order.submit();
        order.confirm();
    }

}
