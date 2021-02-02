/**
 * An abstraction of a Booking object made by a student
 */
public class Booking {
    private Student student;
    private Facility facility;
    private BrosDate startDate;
    private BrosDate bookingDate;
    private int duration;

    /**
     * Constructs a specific Booking object
     * @param student the student making the booking
     * @param facility the facility being booked
     * @param startDate the booking date of the facility
     * @param duration the duration of the booking
     */
    public Booking(Student student, Facility facility, BrosDate startDate, int duration) {
        this.student = student;
        this.facility = facility;
        this.startDate = startDate;
        this.duration = duration;
        this.bookingDate = new BrosDate();
    }

    /**
     * Constructs a specific Booking object. This should only be used by the
     * BookingDAO to create the initial list of bookings
     * @param student the student making the booking
     * @param facility the facility being booked
     * @param bookingDate the date when the booking is made by the student.
     * @param startDate the booking date of the facility
     * @param duration the duration of the booking
     */
    public Booking(Student student, Facility facility, BrosDate bookingDate, BrosDate startDate, int duration) {
        this.student = student;
        this.facility = facility;
        this.startDate = startDate;
        this.bookingDate = bookingDate;
        this.duration = duration;
    }

    /**
     * Gets the duration of this booking
     * @return  the booking's duration
     */
    public int getDuration() {
        return duration;
    }
    
    /**
     * Gets the student who made the booking
     * @return the student object
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Gets the facility being booked
     * @return the facility object
     */
    public Facility getFacility() {
        return facility;
    }

    /**
     * Gets the start date of the booking
     * @return the booking start date
     */
    public BrosDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the end date of the booking
     * @return  the booking end date
     */
    public BrosDate getEndDate() {
        if (this.getDuration() > 0 ){

            return this.startDate.computeDate(this.getDuration());
        }
        return null;
    }

    /**
     * gets the price of this booking
     * @return the price that the booking costs 
     * (taking into consideration the rate of the facility and the duration)
     */
    public int getPrice() {
        // complete the code
        int price = getDuration() * 2;
        return price;
    }

    /**
     * Gets the booking date
     * @return the date where this booking is made
     */
    public BrosDate getBookingDate() {
        return bookingDate;
    }

    /**
     * checks whether this booking overlaps with another booking
     * @param another the other booking object
     * @return true if this booking overlaps the other. Otherwise, return false
     */
    public boolean overlaps(Booking another) {
        if (this.startDate.equals(another.startDate) || (this.getEndDate().equals(another.getEndDate()))){
            return true;
        }
        else if (this.startDate.after(another.startDate)&& this.getEndDate().before(another.getEndDate())){
            return true;
        }
        else if (this.startDate.before(another.startDate) && this.getEndDate().after(another.getEndDate())){
            return true;
        }
        else if (this.startDate.before(another.startDate) && this.getEndDate().after(another.startDate)){
            return true;
        }
        else if (this.startDate.before(another.getEndDate()) && this.getEndDate().after(another.getEndDate())){
            return true;
        }

        return false;
    }
}
