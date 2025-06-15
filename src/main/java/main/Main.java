package main;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import static ui.MenuManager.*;
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int op;
            do {
                clear();
                logo();
                showMenu();
                System.out.print(">>> ");
                op = scanner.nextInt();
                scanner.nextLine();
                switch (op) {
                    case 1:
                        save(scanner);
                        break;
                    case 2:
                        remove(scanner);
                        break;
                    case 3:
                        update(scanner);
                        break;
                    case 4:
                        findAll(scanner);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid option");
                        TimeUnit.SECONDS.sleep(3);

                }
            } while (op != 0);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

