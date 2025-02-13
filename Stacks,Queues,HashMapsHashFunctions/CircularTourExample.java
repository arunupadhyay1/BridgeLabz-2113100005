public class CircularTourExample {
    public static void main(String[] args) {
        CircularTour ct = new CircularTour();
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int start = ct.tour(petrol, distance);
        System.out.println(start); // Output: 1
    }
}
class CircularTour {
    public int tour(int[] petrol, int[] distance) {
        int totalPetrol = 0, totalDistance = 0, currentPetrol = 0, start = 0;
        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            currentPetrol += petrol[i] - distance[i];
            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }
        return totalPetrol >= totalDistance ? start : -1;
    }
}

