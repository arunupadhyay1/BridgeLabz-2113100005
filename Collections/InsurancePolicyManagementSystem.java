import java.util.*;

class InsurancePolicyManagementSystem {
    private static Set<Policy> hashSet = new HashSet<>();
    private static Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private static Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    public static void main(String[] args) {
        addPolicies();
        retrievePolicies();
        performanceComparison();
    }

    public static void addPolicies() {
        Policy p1 = new Policy("001", "John Doe", "2023-12-01", "Health", 500.0);
        Policy p2 = new Policy("002", "Jane Doe", "2023-11-15", "Auto", 300.0);
        Policy p3 = new Policy("003", "Jim Doe", "2024-01-20", "Home", 400.0);
        hashSet.add(p1);
        linkedHashSet.add(p2);
        treeSet.add(p3);
    }

    public static void retrievePolicies() {
        System.out.println("All unique policies: " + hashSet);
        System.out.println("Policies expiring soon: " + treeSet);
    }

    public static void performanceComparison() {
        long startTime = System.nanoTime();
        hashSet.add(new Policy("004", "Jake Doe", "2023-10-10", "Health", 600.0));
        long endTime = System.nanoTime();
        System.out.println("HashSet add time: " + (endTime - startTime));

        startTime = System.nanoTime();
        linkedHashSet.add(new Policy("005", "Jill Doe", "2023-09-10", "Auto", 350.0));
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (endTime - startTime));

        startTime = System.nanoTime();
        treeSet.add(new Policy("006", "Jack Doe", "2023-08-10", "Home", 450.0));
        endTime = System.nanoTime();
        System.out.println("TreeSet add time: " + (endTime - startTime));
    }
}

class Policy {
    private String policyNumber;
    private String policyholderName;
    private String expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}