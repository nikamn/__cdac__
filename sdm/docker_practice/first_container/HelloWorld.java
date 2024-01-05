import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello from Nishant @...!");

        System.out.println("Give input a");
        int a = scanner.nextInt();

        System.out.println("Give input b");
        int b = scanner.nextInt();

        System.out.println("Addition of a + b = " + (a + b));

        scanner.close();
    }
}