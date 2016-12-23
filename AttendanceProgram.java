import java.io.IOException;
import java.util.Scanner;

public class AttendanceProgram {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);
		int num_of_classes, num_of_students;
		System.out.println("Number of classes?");
		num_of_classes = userInput.nextInt();
		System.out.println("Number of people?");
		num_of_students = userInput.nextInt();
		// have the number of classes and students for taking attendance
		Student[][] Attendance = new Student[num_of_classes][num_of_students];
		takeAttendance(Attendance, num_of_classes, num_of_students);
		printAttendance(Attendance, num_of_classes, num_of_students);
	}

	/* A function for typing in the attendance for the day. */
	public static void takeAttendance(Student[][] Attendance, int classes, int student) throws IOException {
		Scanner userInput = new Scanner(System.in);
		int class_num, present;
		String studentName, done;

		// need to make sure that the 2d array has enough room to take
		// attendance
		int[] record = new int[classes];
		for (int i = 0; i < record.length; i++) {
			record[i] = student;
		}

		System.out.println(
				"Type in \"Done\" whenever you are finished with taking attendance. Otherwise, please type in the class number, name of the student, and the attendance.\nFor taking attendance, please put in 1 if present, 0 if not.");
		do {
			System.out.println("Class number?");
			class_num = userInput.nextInt();
			System.out.println("Name of student?");
			studentName = userInput.next();
			System.out.println("Present in class?");
			present = userInput.nextInt();
			if (record[class_num - 1] > 0) {
				int nth = student - record[class_num - 1];
				Student stdnt = new Student(studentName, present, class_num);
				Attendance[class_num - 1][nth] = stdnt;
				record[class_num - 1] = record[class_num - 1] - 1;
			} else {
				System.out.println("You already took attendance for all the students in the class. Please try again.");
			}
			System.out.println("Continue taking attendance? Type \"Done\" if you are finished. Otherwise type in anything and press enter.");
			done = userInput.next();
		} while (!done.equalsIgnoreCase("Done"));
	}

	public static void printAttendance(Student[][] Attendance, int classes, int student) {
		for (int i = 0; i < classes; i++) {
			for (int k = 0; k < student; k++) {
				if (Attendance[i][k] != null) {
					Student stdnt = Attendance[i][k];
					String present;
					if (stdnt.getPresent() == 1) {
						present = "present.";
					} else {
						present = "not present.";
					}
					System.out.println("Student named " + stdnt.getName() + " of class " + stdnt.getClassNum() + " was "
							+ present);
				}
			}
		}
	}

}