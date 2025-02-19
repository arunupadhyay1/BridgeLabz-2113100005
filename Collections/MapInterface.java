import java.io.*;
import java.util.*;

class MapInterface {
    public static void main(String[] args) {
        wordFrequencyCounter();
        invertMap();
        findKeyWithHighestValue();
        mergeTwoMaps();
        groupObjectsByProperty();
    }

    public static void wordFrequencyCounter() {
        String text = "Hello world, hello Java!";
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(frequencyMap);
    }

    public static void invertMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);
        Map<Integer, List<String>> invertedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        System.out.println(invertedMap);
    }

    public static void findKeyWithHighestValue() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        String maxKey = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(maxKey);
    }

    public static void mergeTwoMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        map2.forEach((key, value) -> mergedMap.merge(key, value, Integer::sum));
        System.out.println(mergedMap);
    }

    public static void groupObjectsByProperty() {
        List<Employee> employees = Arrays.asList(new Employee("Alice", "HR"), new Employee("Bob", "IT"), new Employee("Carol", "HR"));
        Map<String, List<Employee>> groupedByDepartment = new HashMap<>();
        for (Employee emp : employees) {
            groupedByDepartment.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp);
        }
        System.out.println(groupedByDepartment);
    }
}

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}