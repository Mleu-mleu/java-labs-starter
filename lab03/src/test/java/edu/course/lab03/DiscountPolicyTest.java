package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountPolicyTest {

    @Test
    void noDiscount_returnsSamePrice() {
        DiscountPolicy policy = new NoDiscount();
        assertEquals(100.0, policy.apply(100.0), 1e-9);
    }

    @Test
    void noDiscount_rejectsNegativePrice() {
        DiscountPolicy policy = new NoDiscount();
        assertThrows(IllegalArgumentException.class, () -> {
            policy.apply(-10.0);
        });
    }

    @Test
    void percentDiscount_calculatesCorrectly() {
        DiscountPolicy policy = new PercentDiscount(20);
        assertEquals(80.0, policy.apply(100.0), 1e-9);
        DiscountPolicy halfPolicy = new PercentDiscount(50);
        assertEquals(100.0, halfPolicy.apply(200.0), 1e-9);
    }

    @Test
    void percentDiscount_rejectsInvalidPercent() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(-1));
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(101));
    }

    @Test
    void percentDiscount_rejectsNegativePrice() {
        DiscountPolicy policy = new PercentDiscount(20);
        assertThrows(IllegalArgumentException.class, () -> {
            policy.apply(-50.0);
        });
    }

    @Test
    void priceCalculator_swapsPolicyWithoutCodeChange() {
        PriceCalculator calc1 = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calc1.calculator(100.0), 1e-9);
        PriceCalculator calc2 = new PriceCalculator(new PercentDiscount(20));
        assertEquals(80.0, calc2.calculator(100.0), 1e-9);
    }

    @Test
    void priceCalculator_throwsExceptionOnNullPolicy() {
        assertThrows(IllegalArgumentException.class, () -> new PriceCalculator(null));
    }
}