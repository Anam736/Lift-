import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter total number of floors: ");
        int totalfloors = sc.nextInt();
        
        // Get current floor and number of requested floors
        System.out.print("Enter current floor: ");
        int currentfloor = sc.nextInt();
        if (currentfloor > totalfloors)
        {
            System.out.println("Invalid floor input. Exiting the program.");
            return;
        }
    
        System.out.print("Enter number of requesting floors: ");
        int n = sc.nextInt();
        int[] requestedfloors = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the requesting floor " + (i + 1) + ": ");
            requestedfloors[i] = sc.nextInt();
        }
        Arrays.sort(requestedfloors);
        int[] nearestfloors = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        int i = 0;
        while (i < n) {
            int nearestdistance = Integer.MAX_VALUE;
            int nearestfloor = -1;
            int nearestindex = -1;
            
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int distance = Math.abs(currentfloor-requestedfloors[j]);
                    if (distance < nearestdistance) {
                        nearestdistance = distance;
                        nearestfloor = requestedfloors[j];
                        nearestindex =j;
                    }
                }
            }
            nearestfloors[i] = nearestfloor;
            visited[nearestindex] =true;
            currentfloor = nearestfloor;
            i++;
        }
        System.out.print("The order in which the lift goes is: ");
        for (int floor : nearestfloors) {
            System.out.print(floor + " ");
        }
    }
}
