package managerStudent.demo;

import java.util.Scanner;

import managerStudent.demo.service.StudentService;

public class demoApplication {

	public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice;
            StudentService service = new StudentService();
            while (true) {
                System.out.println("----------List Function-------------");
                System.out.println("1.Add Student");
                System.out.println("2.Show List Student");
                System.out.println("3.Search Student by ID");
                System.out.println("4.Update Student");
                System.out.println("5.Delete Student");
                System.out.println("6.Show % of academic performance");
                System.out.println("7.Show % GPA");
                System.out.println("8.Find students by academic ability");
                System.out.println("9.Save Students To File");
                System.out.println("0.Exit");
                System.out.println("----------------------------");
                System.out.print("Please Choose Function!!!");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        service.addStudent();
                        break;
                    case 2:
                        service.displayStudent();
                        break;
                    case 3:
                        service.searchStudentID();
                        break;
                    case 4:
                        service.updateStudent();
                        break;
                    case 5:
                        service.deleteStudent();
                        break;
                    case 6:
                        service.academicPercentage();
                        break;
                    case 7:
                        service.percentageGPA();
                        break;
                    case 8:
                        service.findbyAcademicAbility();
                        break;
                    case 9:
                        service.saveStudentsToFile();
                        break;
                    case 0:
                        System.out.println("See You Again.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please Choose Function!!!");
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }
    }
}
