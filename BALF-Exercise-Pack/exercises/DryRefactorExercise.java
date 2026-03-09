import java.util.List;

public class DryRefactorExercise {

    public static void main(String[] args) {
        List<String> users = List.of("Alice", "Bob", "Clara");

        System.out.println("User: " + users.get(0));
        System.out.println("Length: " + users.get(0).length());

        System.out.println("User: " + users.get(1));
        System.out.println("Length: " + users.get(1).length());

        System.out.println("User: " + users.get(2));
        System.out.println("Length: " + users.get(2).length());
    }
}

/*
TASK:
1) Refactor this code so it follows DRY.
2) Keep the same output format.
3) Add one more user without adding copy-paste blocks.
*/
