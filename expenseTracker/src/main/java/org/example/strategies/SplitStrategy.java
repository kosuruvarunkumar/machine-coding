package org.example.strategies;

import java.util.Map;

public interface SplitStrategy {
    Map<String, Double> split(int amount, Map<String, Double> splits);
}
