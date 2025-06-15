package ui;
import domain.Student;
import service.StudentService;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public final class MenuManager {
    public static void update(Scanner scanner) throws SQLException, InterruptedException {
        System.out.println("==========Update_Student==========");
        System.out.println("Type the id to update");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Type the name of the student");
        String name = scanner.nextLine();
        System.out.println("Type the age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Type the grade");
        String grade = scanner.nextLine();
        System.out.println("Type the mark");
        float mark = Float.parseFloat(scanner.nextLine());
        Student student = Student.builder().name(name).age(age).grade(grade).mark(mark).build();
        System.out.print("Updating the student...");
        StudentService.update(student,idToUpdate,false);
        System.out.print("Ok!!"+'\n');
        TimeUnit.SECONDS.sleep(2);
    }

    public static void remove(Scanner scanner) throws SQLException, InterruptedException {
        System.out.println("==========Remove_Student=========");
        System.out.println("Type the id to remove");
        int idToRemove = scanner.nextInt();
        System.out.print("Removing the student...");
        StudentService.delete(idToRemove,false);
        System.out.print("Ok!!"+'\n');
        TimeUnit.SECONDS.sleep(2);
    }

    public static void findAll(Scanner scanner) throws SQLException {
        clear();
        System.out.println("==========Find_all==========");
        StudentService.findAll(false).forEach(System.out::println);
        System.out.println("Enter to exit");
        scanner.nextLine();
    }
    public static void save(Scanner scanner) throws SQLException, InterruptedException {
        clear();
        System.out.println("==========Add_Student==========");
        System.out.println("Type the name of the student");
        String name = scanner.nextLine();
        System.out.println("Type the age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Type the grade");
        String grade = scanner.nextLine();
        System.out.println("Type the mark");
        float mark = Float.parseFloat(scanner.nextLine());
        Student student = Student.builder().name(name).age(age).grade(grade).mark(Float.valueOf(mark)).build();
        System.out.print("Saving in the database...");
        StudentService.save(student,false);
        System.out.print("Ok!!"+'\n');
        TimeUnit.SECONDS.sleep(2);
    }

    public static void showMenu() {
        System.out.println("1 * Add student");
        System.out.println("2 * Remove student");
        System.out.println("3 * Update student");
        System.out.println("4 * Find all student");
        System.out.println("0 * Exit");
    }

    public static void clear() {
        System.out.println("\n".repeat(50));
    }

    public static void logo() {
        String goldenColor = "\033[38;2;212;175;55m";
        String resetColor = "\033[0m";

        String[] asciiArt = {
                "   _____      _                 _    _____           _                 ",
                "  / ____|    | |               | |  / ____|         | |                ",
                " | (___   ___| |__   ___   ___ | | | (___  _   _ ___| |_ ___ _ __ ___  ",
                "  \\___ \\ / __| '_ \\ / _ \\ / _ \\| |  \\___ \\| | | / __| __/ _ \\ '_ ` _ \\ ",
                "  ____) | (__| | | | (_) | (_) | |  ____) | |_| \\__ \\ ||  __/ | | | | |",
                " |_____/ \\___|_| |_|\\___/ \\___/|_| |_____/ \\__, |___/\\__\\___|_| |_| |_|",
                "                                            __/ |                      ",
                "                                           |___/                       "
        };

        for (String line : asciiArt) {
            System.out.println(goldenColor + line + resetColor);
        }
    }

}



