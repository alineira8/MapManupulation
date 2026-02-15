import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudentManager {
    private HashMap<Integer, String> students = new HashMap<>();

    public void addStudent(int id, String name) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative!");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null!");
        }

        students.put(id, name.trim());
        System.out.println("Added student: " + id + " -> " + name.trim());
    }

    public void removeStudent(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative!");
        }

        String removed = students.remove(id);

        if (removed == null) {
            System.out.println("Student with ID " + id + " not found.");
        } else {
            System.out.println("Removed student: " + id + " -> " + removed);
        }
    }

    public TreeMap<Integer, String> getSortedRecords() {
        return new TreeMap<>(students);
    }

    public void showHighestIdStudent() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        TreeMap<Integer, String> sorted = getSortedRecords();
        int highestId = sorted.lastKey();
        System.out.println("Highest ID student: " + highestId + " -> " + sorted.get(highestId));
    }

    public void showLowestIdStudent() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        TreeMap<Integer, String> sorted = getSortedRecords();
        int lowestId = sorted.firstKey();
        System.out.println("Lowest ID student: " + lowestId + " -> " + sorted.get(lowestId));
    }

    public void displayAll() {
        System.out.println("\n--- Current Students (HashMap) ---");
        System.out.println(students);
    }

    public void displaySorted() {
        System.out.println("\n--- Students Sorted by ID (TreeMap) ---");
        for (Map.Entry<Integer, String> entry : getSortedRecords().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}