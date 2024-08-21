package com.verkeerslicht.datastructures;


public class AutoComparator<T> {
    public int compare(T obj1, T obj2, java.util.function.Function<T, Integer> priorityExtractor) {
        int priority1 = priorityExtractor.apply(obj1);
        int priority2 = priorityExtractor.apply(obj2);
        return Integer.compare(priority1, priority2);
}}
