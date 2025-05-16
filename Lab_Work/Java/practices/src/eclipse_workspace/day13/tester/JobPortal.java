package eclipse_workspace.day13.tester;

import eclipse_workspace.day13.comparators.DobComparator;
import eclipse_workspace.day13.comparators.GraduationDateComparator;
import eclipse_workspace.day13.jobportal.Degree;
import eclipse_workspace.day13.jobportal.JobSeeker;
import java.time.LocalDate;

import java.util.*;

public class JobPortal {
    private static int choice=-1;
    private static Scanner sc = new Scanner(System.in);
    private static Set<JobSeeker> jobSeekers= new HashSet<>();

    public static void main(String[] args) {
        printMenu();

        do {
            System.out.println("Please enter your choice");
            choice=sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: registerJobSeeker();
                break;

                case 2: updateEmail();
                break;

                case 3: displayByDegree();
                break;

                case 4: sortByEmail();
                break;

                case 5: sortByDob();
                break;

                case 6: sortByGraduationDate();
                break;

                case 0:
                    System.out.println("Closing resource..");
                    sc.close();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }while (choice !=0);
    }

    private static void printMenu() {
        System.out.println("------------ Menus ------------\n" +
                "1 JobSeeker registration\n" +
                "2 Update email\n" +
                "3 Display all job seeker by their degree type. take degree from user\n" +
                "4 Sort JobSeeker details as per email (Comparable)\n" +
                "5 Sort JobSeeker details as per dob (Comparator)\n" +
                "6 Sort customer details as per graduationDate (Comparator)\n");
    }

    private static void registerJobSeeker() {
        try {
            System.out.print("Registration ID: ");
            String regId = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            System.out.print("Date of Birth (yyyy-mm-dd): ");
            LocalDate dob = LocalDate.parse(sc.nextLine());

            System.out.print("Aadhar ID: ");
            String aadhar = sc.nextLine();

            System.out.print("Phone Number (10 digits): ");
            String phone = sc.nextLine();

            System.out.print("Graduation Date (yyyy-mm-dd): ");
            LocalDate gradDate = LocalDate.parse(sc.nextLine());

            System.out.print("Degree (BACHELOR, MASTER, etc.): ");
            Degree degree = Degree.valueOf(sc.nextLine().toUpperCase());

            JobSeeker js = new JobSeeker(regId, name, email, password, dob, aadhar, phone, gradDate, degree);

            if (jobSeekers.add(js)) {
                System.out.println("Registration successful.");
            } else {
                System.out.println("JobSeeker already exists.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateEmail() {
        System.out.print("Enter Registration ID: ");
        String regId = sc.nextLine();

        System.out.print("Enter Old Email: ");
        String oldEmail = sc.nextLine();

        System.out.print("Enter New Email: ");
        String newEmail = sc.nextLine();

        for (JobSeeker js : jobSeekers) {
            if (js.getRegistrationId().equals(regId) && js.getEmail().equalsIgnoreCase(oldEmail)) {
                js.setEmail(newEmail);
                System.out.println("Email updated.");
                return;
            }
        }

        System.out.println("JobSeeker not found.");
    }

    private static void displayByDegree() {
        System.out.print("Enter Degree to filter by (e.g., MASTER): ");
        Degree degree = Degree.valueOf(sc.nextLine().toUpperCase());

        for(JobSeeker js: jobSeekers){
            if(js.getDegree() == degree) System.out.println(js);
        }
    }

    private static void sortByEmail() {
        // Can't sort a Set directly so copying data to ArrayList to sort
        List<JobSeeker> list = new ArrayList<>(jobSeekers);
        Collections.sort(list);
        list.forEach(System.out::println);
    }

    private static void sortByDob() {
        List<JobSeeker> list = new ArrayList<>(jobSeekers);
        list.sort(new DobComparator());
        list.forEach(System.out::println);
    }

    private static void sortByGraduationDate() {
        List<JobSeeker> list = new ArrayList<>(jobSeekers);
        list.sort(new GraduationDateComparator());
        list.forEach(System.out::println);
    }

}
