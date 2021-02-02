import java.lang.reflect.Array;
import java.util.*;

/**
 * This is in charge of the user interface of the booking system.
 * You should write all the println and sc.nextXX() methods here (single responsibility).
 *
 */
public class BrosMenu {
    private StudentDAO studentDAO;
    private FacilityDAO facilityDAO;
    private BookingDAO bookingDAO;

    /**
     * Creates the BrosMenu object.
     * The DAO objects (StudentDAO, FacilityDAO and BookingDAO)
     * are initialized here.
     */
    public BrosMenu() {
        this.studentDAO = new StudentDAO();
        this.facilityDAO = new FacilityDAO();
        this.bookingDAO = new BookingDAO(studentDAO,facilityDAO);
    }    

    /**
     * Displays the menu
     */
    public void displayMenu() {
        System.out.println();
        System.out.println("== BROS :: Main Menu ==");
        System.out.println("1. List all Students");
        System.out.println("2. List all Facilities");
        System.out.println("3. List all Bookings");
        System.out.println("4. List all Bookings by a student");
        System.out.println("5. Add a Student");
        System.out.println("6. Book a Facility");
        System.out.println("7. Quit Application");
        System.out.print("Enter your choice >");
    }


    /**
     * This is the method that kick starts the whole application.
     * It runs in a loop (until the user selects to quit). In
     * each iteration, it displays the menu by calling displayMenu(),
     * prompts the user to select a choice,
     * and then invoke the processXX method to process the request.
     */
    public void execute() {
        //
        // should continue to loop until the user chooses to quit
        boolean notQuit = true;
        while (notQuit) {
            displayMenu();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    processListAllStudent();
                    break;
                case 2:
                    processListAllFacilities();
                    break;
                case 3:
                    processListAllBookings();
                    break;
                case 4:
                    processListAllBookingByAStudent();
                    break;
                case 5:
                    processAddAStudent();
                    break;
                case 6:
                    processBookAFacility();
                    break;
                case 7:
                    notQuit = false;
                    break;
                default:
                    System.out.println("You did not enter a valid option (1 to 7)");
            }
        }
    }

    /**
     * Process the request of listing all students in the system.
     */
    public void processListAllStudent() {
        ArrayList<Student> list = this.studentDAO.retrieveAll();
        System.out.println("S/N" + " " + "Username" + "  " + "Name" + "          " + "eDollars");
        for (int i = 0; i < list.size();i++ ){
//
            System.out.format("%-4d",i+1); System.out.format("%-10s", list.get(i).getUsername());System.out.format("%-15s", list.get(i).getName()); System.out.format("%3d",list.get(i).getBalance());
            System.out.println();


//            System.out.format("%8d", i+1); System.out.format("%20d", list.get(i).getUsername()); System.out.format("%20d", list.get(i).getName()); System.out.format("%5d",list.get(i).getBalance());  System.out.println();



        }
    }

    /**
     * Process the request of listing all facilities in the system.
     */
    public void processListAllFacilities() {
        ArrayList<Facility> faclist = this.facilityDAO.retrieveAll();
        System.out.println("S/N" + " " +"ID" + "     " + "Description" + "    " + "Capacity" );
        for (int i = 0; i < faclist.size(); i ++){
            System.out.format("%-4d",i+1); System.out.format("%-7s",faclist.get(i).getId()); System.out.format("%-15s",faclist.get(i).getDescription());System.out.format("%-2d",faclist.get(i).getCapacity());
            System.out.println();

        }
    }

    /**
     * Process the request of listing all bookings in the system.
     */
    public void processListAllBookings() {
        ArrayList<Booking> bookList = this.bookingDAO.retrieveAll();
        System.out.println("Facility   Booking DateTime   Start DateTime   Duration   Student");
        for (int i = 0; i < bookList.size(); i ++){
            System.out.format("%-11s",bookList.get(i).getFacility().getId());
            System.out.format("%-19s",bookList.get(i).getBookingDate().toString());
            System.out.format("%-18s",bookList.get(i).getStartDate().toString());
            System.out.format("%-10s",bookList.get(i).getDuration());
            System.out.println(bookList.get(i).getStudent().getUsername());

        }
    }

    /**
     * Process the request of adding a student in the system.
     * 1. Prompts the user for the username, full name and initial balance of the student.
     * 2. Adds the student object to the list managed by the StudentDAO.
     */
    public void processAddAStudent() {
        Scanner sc = new Scanner(System.in);
        boolean isValidUser = false;
        String username;
        do {
            System.out.println("Choose a username:");
            username = sc.nextLine();
            if (studentDAO.retrieve(username) != null){
                System.out.println("Invalid Username");
            }
            else{
                isValidUser = true;
            }

        }while (isValidUser = true);


        System.out.println("Enter your full name");
        String name = sc.nextLine();
        System.out.println("How much money do you have?");
        int eDollars = sc.nextInt();
        studentDAO.add(username,name,eDollars);
        System.out.println("Successfully added");
        return;
    }


    /**
     * Process the request of listing all the bookings by a specific user.
     * 1. Prompts the user for the username
     * 2. Displays the list of bookings by the student
     */
    public void processListAllBookingByAStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username:");
        String username = sc.nextLine();
        ArrayList<Booking> user = new ArrayList<>();
        user = bookingDAO.retrieve(username);
        for (int i = 0; i < user.size(); i++){
            System.out.println(user.get(i).getStartDate().toString());
        }

    }

    /**
     * Process the request of booking a facility.
     * 1. Prompt the user for username, facility ID, start date and time, and duration
     * 2. Perform the validations (in the writeup). For example, insufficient balance etc
     * 3. Adds the booking object to the list managed by the BookingDAO
     */
    public void processBookAFacility() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = sc.nextLine();
        if (studentDAO.retrieve(username) == null){
            System.out.println("Invalid Username");
            return;
        }
        Student studentbook = studentDAO.retrieve(username);

        System.out.println("Enter Facility ID");
        String facility = sc.nextLine();
        if (facilityDAO.retrieve(facility) == null){
            System.out.println("Invalid Facility ID");
            return;
        }
        Facility facilitybook = facilityDAO.retrieve(facility);

        System.out.println("Enter start date (DD/MM/YYYY) ");
        String startDate = sc.nextLine();
        System.out.println("Enter start time (HH:00) ");
        String startTime = sc.nextLine();
        String startDateTime = startDate + " " +startTime;
        BrosDate time = new BrosDate(startDateTime);
        System.out.println("Enter Duration");
        int duration = sc.nextInt();
        int cost = duration * 2 ;
        if (cost > studentbook.getBalance()){
            System.out.println("Not enough balance");
            return;
        }
        Booking another = new Booking(studentbook,facilitybook,time,duration);
        ArrayList<Booking> bookinglist = bookingDAO.retrieveAll();
        if (bookinglist.add(another) == true){
            System.out.println("Successfully Added");
            studentDAO.retrieve(username).deduct(cost);
        }
        else{
            System.out.println("Invalid Booking");
        }
//        for (int i = 0; i < bookinglist.size(); i ++){
//            if (bookinglist.get(i).getFacility().getId() == facilitybook.getId()){
//                if (bookinglist.get(i).overlaps(another) == true){
//                    System.out.println("Booking overlaps with another booking. Please try again.");
//                    return;
//                }
//            }
//
//        }




    }
}
