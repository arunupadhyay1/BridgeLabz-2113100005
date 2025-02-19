import java.util.*;

class InsurancePolicyManagement2 {
    private static Map<String, Policy> hashMap = new HashMap<>();
    private static Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private static Map<String, Policy> treeMap = new TreeMap<>(); // Ordering by String keys (policy numbers)

    public static void main(String[] args) {
        addPolicies();
        retrievePolicies();
    }

    public static void addPolicies() {
        Policy p1 = new Policy("001", "John Doe", "2023-12-01", "Health", 500.0);
        Policy p2 = new Policy("002", "Jane Doe", "2023-11-15", "Auto", 300.0);
        Policy p3 = new Policy("003", "Jim Doe", "2024-01-20", "Home", 400.0);
        hashMap.put(p1.getPolicyNumber(), p1);
        linkedHashMap.put(p2.getPolicyNumber(), p2);
        treeMap.put(p3.getPolicyNumber(), p3); // Ordering by policy number
    }

    public static void retrievePolicies() {
        System.out.println("All unique policies: " + hashMap.values());
        System.out.println("Policies sorted by policy number: " + treeMap.values());
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

    public String getPolicyNumber() {
        return policyNumber;
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