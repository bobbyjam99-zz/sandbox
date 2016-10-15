package org.bobbyjam99.javase8.stream;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DiscountImprerative {

    @Test
    public void oldway() {
        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12")
        );

        BigDecimal totalOfDiscountPrices = BigDecimal.ZERO;

        for(BigDecimal price : prices) {
            if(price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalOfDiscountPrices = totalOfDiscountPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        System.out.println("Total of discounted prices:" + totalOfDiscountPrices);
    }

    @Test
    public void betterway() {
        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12")
        );

        final BigDecimal totalOfDiscountPrices =
                prices.stream()
                        .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                        .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total of discounted prices:" + totalOfDiscountPrices);
    }
}
