import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The BookingDAO is in charge of the Bookings objects in the system.
 */
public class BookingDAO {
    // instance variables required

    private ArrayList<Booking> bookingList;

    /**
     * Constructs a BookingDAO object.
     * @param studentDAO  the StudentDAO object
     * @param facilityDAO  the FacilityDAO object
     */
    public BookingDAO(StudentDAO studentDAO, FacilityDAO facilityDAO) {

        bookingList = new ArrayList<>();
        bookingList.add(new Booking(studentDAO.retrieve("raini"), facilityDAO.retrieve("F005"), new BrosDate("28/09/2016 16:05"),new BrosDate("14/11/2016 15:00"), 2));

    }

    /**
     * Retrieves all the Bookings in the system
     * @return the list of bookings
     */
    public ArrayList<Booking> retrieveAll() {
        if (this.bookingList.size() == 0){
            return null;
        }
        else{
            return this.bookingList;
        }

    }

    /**
     * Retrieves the list of bookings that belongs to a specific student
     * @param username the student username
     * @return  the list of student's booking or an empty ArrayList if this student has no booking
     */
    public ArrayList<Booking> retrieve(String username) {
        ArrayList<Booking> user = new ArrayList<>();
        for (int i = 0; i < this.bookingList.size();i++){
            Booking check = this.bookingList.get(i);
            if (check.getStudent().getUsername().equals(username)){
                user.add(check);
            }

        }
        return user;
    }

    /**
     * Checks that this newBooking timing does not overlap with an existing booking.
     * Then it adds the new booking to the list managed by this DAO.
     * @param newBooking the new Booking object
     * @return true if this booking is added successfully (i.e. there are no overlap with an
     *         existing booking, false otherwise.
     */
    public boolean add(Booking newBooking) {
        for (int i = 0; i < bookingList.size();i++){
            if (bookingList.get(i).getFacility().getId() == newBooking.getFacility().getId()){
                if (bookingList.get(i).overlaps(newBooking)){
                    return false;
                }
            }

        }

        bookingList.add(newBooking);
        return true;

    }
}
