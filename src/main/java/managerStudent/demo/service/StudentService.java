package managerStudent.demo.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import managerStudent.demo.model.Rank;
import managerStudent.demo.model.Student;
import managerStudent.demo.validate.Validator;

public class StudentService {

	    private Scanner scanner = new Scanner(System.in);
	    private static final int MAX_STUDENTS = 100;
	    private static Student[] studentArray = new Student[MAX_STUDENTS];
	    private List<Student> students = new ArrayList<>();
	    private int count;

	    public StudentService() {
	        fakeData();
	    }

	    public void fakeData() {
	        studentArray[0] = new Student("Viet Hoang", ("22-01-2003"), "Lang Son", 163, 55,
	                "Oceantech1", "KMA", 2021, 8);
	        studentArray[1] = new Student("Dang Quang", ("02-9-2003"), "Lang Son", 170, 65,
	                "Oceantech2", "KMA", 2021, 6);
	        studentArray[2] = new Student("Phuc Hung", ("23-01-2003"), "Nam Dinh", 172, 65,
	                "Oceantech3", "KMA", 2021, 7);
	        studentArray[3] = new Student("Huu Khiem", ("14-7-2003"), "Bac Giang", 175, 55,
	                "Oceantech4", "KMA", 2021, 3);
	        count += 4;
	        students.add(studentArray[0]);
	        students.add(studentArray[1]);
	        students.add(studentArray[2]);
	        students.add(studentArray[3]);
	    }

	    public void addStudent() {
	        try {
	            System.out.print("Enter the number of students: ");
	            int numToAdd = Integer.parseInt(scanner.nextLine());
	            for (int i = 0; i < numToAdd; i++) {
	                String name = inputName();
	                String birthDate = inputBirthDate();
	                String address = inputAddress();
	                float height = inputHeight();
	                float weight = inputWeight();
	                String studentCode = inputstudentCode();
	                String School = inputSchool();
	                int startYear = inputStartYear();
	                double score = inputAverage();
	                Student newStudent = new Student(
	                        name, birthDate, address, height, weight, studentCode, School, startYear,
	                        score
	                );
	                System.out.println(newStudent);
	                studentArray[count] = newStudent;
	                count++;
	                students.add(newStudent);
	            }
	        } catch (Exception e) {
	            System.out.println("Enter number!!!");
	        }
	    }

	    public String inputName() {
	        String name;
	        do {
	            name = getInputValue("Name");
	        } while (!Validator.isValidName(name));
	        return name;
	    }

	    public String inputstudentCode() {
	        String studentCode;
	        do {
	            studentCode = getInputValue("StudentCode");
	            
	        } while (!Validator.isValidStudentCode(studentCode));
	        return studentCode;
	    }

	    public float inputHeight() {
	        float height;
	        do {
	            try {
	                height = Float.parseFloat(getInputValue("Height"));
	                if (height >= Validator.MIN_HEIGHT && height <= Validator.MAX_HEIGHT) {
	                    return height;
	                } else
	                    System.out.println("Height from 50 to 300 cm");
	            } catch (Exception e) {
	                System.out.println("Height must be numeric!!! ");
	            }
	        } while (true);
	    }

	    public float inputWeight() {
	        float weight;
	        do {
	            try {
	                weight = Float.parseFloat(getInputValue("Weight"));
	                if (weight >= Validator.MIN_WEIGHT && weight <= Validator.MAX_WEIGHT) {
	                    return weight;
	                } else
	                    System.out.println("Weight from 5 to 1000 kg");
	            } catch (Exception e) {
	                System.out.println("Weight must be numeric!!! ");
	            }
	        } while (true);
	    }

	    public int inputStartYear() {
	        int startYear;
	        do {
	            startYear = Integer.parseInt(getInputValue("Start year"));
	            if (startYear >= Validator.MIN_START_YEAR && startYear <= Year.now().getValue()) {
	                return startYear;
	            } else {
	                System.out.println("The year must start from 1900 ");
	            }

	        } while (!Validator.isStartYear(startYear));
	        return startYear;
	    }

	    public String inputSchool() {
	        String school;
	        do {
	            school = getInputValue("School");
	        } while (!Validator.isValidSchool(school));
	        return school;
	    }


	    public double inputAverage() {
	        double averageScore;
	        do {
	            try {
	            	averageScore = Double.parseDouble(getInputValue("Enter Average score"));
	                if (averageScore > Validator.MIN_GPA && averageScore <= Validator.MAX_GPA) {
	                    return averageScore;
	                } else
	                    System.out.println("Score about 0-10");
	            } catch (Exception e) {
	                System.out.println("Score must be numeric!!! ");
	            }
	        } while (true);
	    }

	    public String inputAddress() {
	        String address;
	        do {
	            address = getInputValue("Address");
	        } while (!Validator.isValidAddress(address));
	        return address;
	    }

	    public String inputBirthDate() {
	        String birthDate;
	        do {
	            birthDate = getInputValue("Birth Date(dd-MM-yyyy)");
	        } while (!Validator.isValidDate(birthDate));
	        return birthDate;
	    }

	    public String getInputValue(String msg) {
	        System.out.printf("%s: ", msg);
	        return scanner.nextLine();
	    }

	    public void displayStudent() {
	        System.out.println("Student List:");
	        if (count == 0) {
	            System.out.println("There are no students on the list");
	        } else {
	            for (Student student : students) {
	                System.out.println(student);
	            }
	        }
	    }

	    public void searchStudentID() {
	        System.out.print("Enter ID to search: ");
	        try {
	            int id = scanner.nextInt();
	            scanner.nextLine();
	            searchStudent(id);
	        } catch (Exception e) {
	            System.out.println("Enter number!!!");
	            scanner.nextLine();
	        }
	    }

	    public Student searchStudent(int id) {
	        for (Student student : studentArray) {
	            if (student != null && student.getId() == id) {
	                System.out.println("About Student: ");
	                System.out.print("ID: " + student.getId());
	                System.out.print(", Name: " + student.getName());
	                System.out.print(", Birth Date: " + student.getBirthDate());
	                System.out.print(", Address: " + student.getAddress());
	                System.out.print(", Height: " + student.getHeight());
	                System.out.print(", Weight: " + student.getWeight());
	                System.out.print(", Student code: " + student.getStudentCode());
	                System.out.print(", School: " + student.getSchool());
	                System.out.print(", Start year: " + student.getStartYear());
	                System.out.print(", Average Score: " + student.getaverageScore());
	                System.out.print(", Rank: " + student.getRank());
	                return student;
	            }
	        }
	        System.out.println("Student with id: " + id + " not found");
	        return null;
	    }

	    public void updateStudent() {
	        System.out.print("Enter the student id that needs update: ");
	        int id = scanner.nextInt();
	        Student updateStudent = searchStudent(id);
	        if (updateStudent != null) {
	            System.out.println();
	            System.out.println("---------Update Informations----------");
	            System.out.println("1. Student code");
	            System.out.println("2. School");
	            System.out.println("3. Start year");
	            System.out.println("4. AverageScore");
	            System.out.println("5. BirthDate");
	            System.out.println("6. Name");
	            System.out.println("7. Address");
	            System.out.println("8. Height");
	            System.out.println("9. Weight");
	            System.out.print("Select item to update: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	            switch (choice) {
	                case 1:
	                    String newStudentCode = inputstudentCode();
	                    updateStudent.setStudentCode(newStudentCode);
	                    break;
	                case 2:
	                    String newSchool = inputSchool();
	                    updateStudent.setSchool(newSchool);
	                    break;
	                case 3:
	                    Integer newStartYear = inputStartYear();
	                    updateStudent.setStartYear(newStartYear);
	                    break;
	                case 4:
	                    Double newScore = inputAverage();
	                    updateStudent.setaverageScore(newScore);
	                    updateStudent.getRank();
	                    break;
	                case 5:
	                    String birthDate = inputBirthDate();
	                    updateStudent.setBirthDate(birthDate);
	                    break;
	                case 6:
	                    String newName = inputName();
	                    updateStudent.setName(newName);
	                    break;
	                case 7:
	                    String newAddress = inputAddress();
	                    updateStudent.setAddress(newAddress);
	                    break;
	                case 8:
	                    Float newHeight = inputHeight();
	                    updateStudent.setHeight(newHeight);
	                    break;
	                case 9:
	                    Float newWeight = inputWeight();
	                    updateStudent.setWeight(newWeight);
	                    break;
	                default:
	                    System.out.println("Select Again!!!.");
	            }

	            System.out.println("Update Student:");
	            System.out.println(updateStudent);
	        } else {
	            return;
	        }
	    }

	    public void deleteStudent() {
	        System.out.print("Enter the student id that needs delete: ");
	        int id = Integer.parseInt(scanner.nextLine());
	        int deleteIndex = -1;
	        for (int i = 0; i < count; i++) {
	            if (studentArray[i] != null && studentArray[i].getId() == id) {
	                deleteIndex = i;
	                break;
	            }
	        }
	        if (deleteIndex != -1) {
	            System.out.println("Delete successful!");
	            for (int j = deleteIndex; j < count - 1; j++) {
	                studentArray[j] = studentArray[j + 1];
	            }
	            students.remove(deleteIndex);
	            studentArray[count - 1] = null;
	            count--;
	        } else {
	            System.out.println("Student with id: " + id + " not found");
	        }
	    }

	    public void academicPercentage() {
	        Map<Rank, Integer> hocLuc = new HashMap<>();
	        int totalStudents = 0; // Tổng số sinh viên

	        for (Student s : studentArray) {
	            if (s != null) {
	                hocLuc.put(s.getRank(), hocLuc.getOrDefault(s.getRank(), 0) + 1);
	                totalStudents++; // Tính tổng số sinh viên
	            }
	        }

	        Map<Rank, Double> phanTramHocLuc = new HashMap<>();
	        DecimalFormat decimalFormat = new DecimalFormat("#.00");

	        for (Rank h : Rank.values()) {
	            int soLuong = hocLuc.getOrDefault(h, 0);
	            double phanTram = (double) soLuong * 100 / totalStudents; // Tính phần trăm dựa trên tổng số sinh viên
	            phanTramHocLuc.put(h, phanTram);
	        }

	        for (Student student : studentArray) {
	            if (student != null) {
	                double phanTram = phanTramHocLuc.get(student.getRank());
	                System.out.println(student);
	                System.out.println("Học Lực: " + student.getRank().name() + " Phần Trăm: " + decimalFormat.format(phanTram) + "%");
	            }
	        }

	    }

	    public void percentageGPA() {
	        Map<Double, Integer> soLuongDiemTrungBinh = new HashMap<>();
	        int tongSoSinhVien = 0;

	        for (Student student : studentArray) {
	            if (student != null) {
	                tongSoSinhVien++;
	                double diemTrungBinh = student.getaverageScore();
	                soLuongDiemTrungBinh.put(diemTrungBinh, soLuongDiemTrungBinh.getOrDefault(diemTrungBinh, 0) + 1);
	            }
	        }

	        System.out.println("Phần trăm điểm trung bình của các sinh viên:");
	        DecimalFormat decimalFormat = new DecimalFormat("#.00");

	        for (Map.Entry<Double, Integer> entry : soLuongDiemTrungBinh.entrySet()) {
	            double diemTrungBinh = entry.getKey();
	            int soLuong = entry.getValue();
	            double phanTram = (double) soLuong / tongSoSinhVien * 100;
	            System.out.println("Average Score " + diemTrungBinh + ": " + decimalFormat.format(phanTram) + "%");
	        }
	    }


	    public void displaybyAcademicPerformance(Rank hocLuc) {
	        System.out.println("List of qualified students (Danh sách sinh viên có học lực) " + hocLuc + ":");

	        for (Student student : studentArray) {
	            if (student != null && student.getRank() == hocLuc) {
	                System.out.println(student);
	                System.out.println("Academic Ability (Học Lực): " + student.getRank());
	            }
	        }
	    }

	    public void findbyAcademicAbility() {
	        String hocLucInput = getInputValue("Enter Academic Ability(YEU, KEM, TB, KHA, GIOI, XUAT_SAC)");
	        try {
	            Rank hocLuc = Rank.valueOf(hocLucInput.toUpperCase());
	            displaybyAcademicPerformance(hocLuc);
	        } catch (IllegalArgumentException e) {
	            System.out.println("Academic Ability Illegal (Học lực không hợp lệ)!!!");
	        }
	    }

	    public void saveStudentsToFile() {
	        ArrayList<Student> list = new ArrayList<>();
	        for (int i = 0; i < count; i++) {
	            Student student = studentArray[i];
	            list.add(student);
	        }
	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter("studentManager.txt"));

	            // Lặp qua danh sách sinh viên và ghi từng dòng vào tệp
	            for (Student student : list) {
	                writer.write(student.toString()); // Chuyển đối tượng sinh viên thành chuỗi và ghi vào tệp
	                writer.newLine(); // Ghi dòng mới
	            }

	            writer.close();

	            System.out.println("Dữ liệu sinh viên đã được lưu vào file.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
