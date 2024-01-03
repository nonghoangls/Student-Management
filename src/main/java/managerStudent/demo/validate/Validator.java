package managerStudent.demo.validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validator {

	 public static final int MAX_NAME_LENGTH = 100;
	    public static final int MAX_ADDRESS_LENGTH = 300;
	    public static final float MIN_HEIGHT = 50;
	    public static final float MAX_HEIGHT = 300;
	    public static final int MIN_WEIGHT = 5;
	    public static final int MAX_WEIGHT = 1000;
	    public static final int STUDENT_CODE_LENGTH = 10;
	    public static final int MAX_SCHOOL_LENGTH = 200;
	    public static final int MIN_START_YEAR = 1900;
	    public static final int MIN_GPA = 0;
	    public static final int MAX_GPA = 10;
	    private static final int MIN_YEAR = 1900;
	    public final static String FILE_NAME = "students.txt";

	    public static boolean isValidName(String name) {
	        if (name.length() < 1) {
	            System.out.println("Name cannot be blank");
	            return false;
	        } else if (name.length() >= MAX_NAME_LENGTH) {
	            System.out.println("Name must not exceed " + MAX_NAME_LENGTH + " characters");
	            return false;
	        } 
//	        else if (!name.matches("[a-zA-Z]+")) {//nếu dùng hàm này sẽ ko cho phép nhập kí tự đặc biệt + số(nhược điểm tên có dấu cách thì sẽ ko input đc)
//	            System.out.println("Name must contain only letters.");
//	            return false;
//	        }
	        return true;
	    }

	    public static boolean isValidStudentCode(String studentCode) {
	        if (studentCode.length() < 1) {
	            System.out.println("Student's Code cannot be blank");
	            return false;
	        } else if (studentCode.length() != STUDENT_CODE_LENGTH) {
	            System.out.println("Student's Code must have " + STUDENT_CODE_LENGTH + " characters");
	            return false;
	        }
	        return true;
	    }


	    public static boolean isValidDate(String dateOfBirth) {
	        if (dateOfBirth.length() < 1) {
	            System.out.println("Dates cannot be left blank!");
	            return false;
	        }
	        try {
	            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            LocalDate localDate = LocalDate.parse(dateOfBirth, dateFormat);
	            if (localDate.getYear() < MIN_YEAR) {
	                System.out.println("Year must be less than " + MIN_YEAR);
	                return false;
	            }
	        } catch (Exception e) {
	            System.out.println("Enter the correct format: (dd-mm-yyyy)");
	            return false;
	        }
	        return true;

	    }

	    public static boolean isValidAddress(String address) {
	        try {
	            if (address.length() < 1) {
	                System.out.println("Address cannot be blank");
	                return false;
	            } else if (address.length() >= MAX_ADDRESS_LENGTH) {
	                System.out.println("Address must not be exceed " + MAX_ADDRESS_LENGTH + " characters");
	                return false;
	            }
	            return true;
	        } catch (Exception e) {
	            System.out.println("ILLEGAL");
	            return false;
	        }

	    }

	    public static boolean isValidSchool(String school) {
	        if (school.length() < 1) {
	            System.out.println("School cannot be blank!!!");
	            return false;
	        } else if (school.length() >= MAX_SCHOOL_LENGTH) {
	            System.out.println("School must not be exceed " + MAX_SCHOOL_LENGTH + " characters");
	            return false;
	        } 
//	        else if (!school.matches("[a-zA-Z]+")) {
//	            System.out.println("School must contain only letters.");
//	            return false;
//	        }
	        return true;
	    }

	    public static Boolean isStartYear(Integer year) {
	        if (year < 1900) {
	            System.out.println("Start year must be greater than 1900");
	            return false;
	        }
	        return true;
	    }

}
