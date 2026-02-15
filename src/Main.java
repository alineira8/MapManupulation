public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        manager.addStudent(101, "Alice");
        manager.addStudent(205, "Queen");
        manager.addStudent(150, "Rusaro");

        manager.displayAll();
        manager.displaySorted();

        manager.showLowestIdStudent();
        manager.showHighestIdStudent();
        manager.removeStudent(150);
        manager.displaySorted();
        try {
            manager.addStudent(-1, "David");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught error: " + e.getMessage());
        }

        try {
            manager.addStudent(300, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught error: " + e.getMessage());
        }

        try {
            manager.addStudent(400, "   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught error: " + e.getMessage());
        }

        try {
            manager.removeStudent(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught error: " + e.getMessage());
        }
    }
}