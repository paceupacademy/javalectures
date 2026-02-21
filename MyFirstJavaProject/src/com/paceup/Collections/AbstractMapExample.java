package com.paceup.Collections;

import java.util.AbstractMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

/**
 * 
 * AbstractMap:
 * - An abstract class that provides a skeletal implementation of the Map interface.
 * - It reduces the effort needed to implement a Map by handling common methods.
 * - Subclasses only need to implement the entrySet() method.
 * - Other methods like put(), get(), remove() work based on entrySet().
 * 
 * Why use AbstractMap?
 * - If you want to create your own custom Map type, you can extend AbstractMap.
 * - You only need to define how entries (key-value pairs) are stored and returned.
 * 
 * In this example:
 * - AbstractMapExample extends AbstractMap.
 * - It uses a HashSet to store Map.Entry objects.
 * - The entrySet() method returns this set.
 */
public class AbstractMapExample<K, V> extends AbstractMap<K, V> {
    // Store entries (key-value pairs) in a HashSet
    private Set<Entry<K, V>> entrySet = new HashSet<>();

    // Must override entrySet() method
    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }

    public static void main(String[] args) {
        AbstractMapExample<Integer, String> map = new AbstractMapExample<>();

        // Adding entries manually
        map.entrySet().add(Map.entry(1, "Apple"));
        map.entrySet().add(Map.entry(2, "Banana"));
        map.entrySet().add(Map.entry(3, "Cherry"));

        // Display map entries
        System.out.println("Custom AbstractMap: " + map);

        // Accessing values using get()
        System.out.println("Value for key 2: " + map.get(2));

        // Removing an entry
        map.entrySet().remove(Map.entry(1, "Apple"));
        System.out.println("After removal: " + map);
    }
}
