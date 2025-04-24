package org.example.strategies;

import java.util.Map;
import java.util.stream.Collectors;

public class EqualSplit implements SplitStrategy {
    @Override
    public Map<String, Double> split(int amount, Map<String, Double> splits) {
        double splitAmount = amount/ splits.size();
        return splits.keySet().stream().collect(Collectors.toMap(u -> u, u -> splitAmount));
    }
}
