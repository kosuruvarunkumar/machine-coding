package org.example.strategies;

import java.util.HashMap;
import java.util.Map;

public class PercentageSplit implements SplitStrategy {
    @Override
    public Map<String, Double> split(int amount, Map<String, Double> splits) {
        double totalPercentage = splits.values().stream().mapToDouble(Double::doubleValue).sum();

        if(Math.abs(totalPercentage - 100) > 0.01) {
            throw new IllegalArgumentException("Total Percentage do not add upto 100");
        }

        Map<String, Double> exactSplits = new HashMap<>();
        for(Map.Entry<String, Double> entry : splits.entrySet()) {
            exactSplits.put(entry.getKey(), (entry.getValue() * amount)/100.0);
        }

        return splits;

    }
}
