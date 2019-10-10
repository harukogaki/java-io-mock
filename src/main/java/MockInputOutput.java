import java.util.Scanner;

public class MockInputOutput {

    public static void doIt() {
        Scanner reader = new Scanner(System.in);
        String name = reader.nextLine();
        System.out.println("Hello my name is " + name);
        System.out.println("Nice to meet you: " + reader.nextInt());

    }
}
