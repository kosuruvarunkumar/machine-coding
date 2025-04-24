package org.example.strategies;

import java.util.Map;

public class ExactSplit implements SplitStrategy {
    @Override
    public Map<String, Double> split(int amount, Map<String, Double> splits) {
        double totalAmount = splits.values().stream().mapToDouble(Double::doubleValue).sum();

        if(Math.abs(totalAmount - amount) > 0.01) {
            throw new IllegalArgumentException("Exact amount do not add upto total amount");
        }

        return splits;
    }
}
