package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.function.Predicate.not;

public class CheckoutSolution {

    private static final Map<String, Price> priceData = Map.of(
            "A", new Price(50, new Offer(3, 130)),
            "B", new Price(30, new Offer(2, 45)),
            "C", new Price(20, null),
            "D", new Price(15, null)
    );

    public Integer checkout(String skus) {
        if (skus == null) {
            return -1;
        }
        if (skus.isEmpty()) {
            return 0;
        }
        String[] skuArray = skus.split("");
        if (Arrays.stream(skuArray)
                .anyMatch(not(priceData::containsKey))) {
            return -1;
        }

        Map<String, Integer> quantityMap = new HashMap<>();

        for (String sku : skuArray) {
            if (quantityMap.containsKey(sku)) {
                quantityMap.put(sku, quantityMap.get(sku) + 1);
            } else {
                quantityMap.put(sku, 1);
            }
        }

        int checkoutAmount = 0;
        for (Map.Entry<String, Integer> item : quantityMap.entrySet()) {
            checkoutAmount += determinePrice(item.getKey(), item.getValue());
        }
        return checkoutAmount;
    }

    int determinePrice(String sku, int quantity) {
        int result = 0;
        Price price = priceData.get(sku);
        if (price != null) {
            Offer offer = price.getOffer();
            if (offer != null) {
                int quotient = Math.divideExact(quantity, offer.quantity);
                int remainder = Math.floorMod(quantity, offer.quantity);
                result += quotient * offer.getPrice();
                result += remainder * price.getIndividualPrice();
            } else {
                result += quantity * price.getIndividualPrice();
            }
        } else {
            return -1;
        }
        return result;
    }
}

