package com.paceup.day16;

import java.util.AbstractMap;
import java.util.Set;
import java.util.HashSet;

public class AbstractMapExample<K, V> extends AbstractMap<K, V> {
    private Set<Entry<K, V>> entrySet = new HashSet<>();

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }

    @Override
    public V put(K key, V value) {
    	remove(key);
        entrySet.add(new SimpleEntry<>(key, value));
        return value;
    }

    public static void main(String[] args) {
        AbstractMapExample<String, Integer> map = new AbstractMapExample<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", null);

        System.out.println(map); // Output: {One=1, Two=2}
    }
}
