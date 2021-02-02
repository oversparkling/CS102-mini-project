/**
 * An abstraction of a real-life facility.
 */
public class Facility {
    private String id;
    private String description;
    private int capacity;
    private int price;

    /**
     * Constructs a specific Facility
     * @param id  the facility unique identifier
     * @param description the facility description
     * @param capacity the facility capacity
     */
    public Facility(String id, String description, int capacity) {
        this.id = id;
        this.description = description;
        this.capacity = capacity;
        this.price = 2;  //fixed 
    }

    /**
     * Gets the unique ID of the facility
     * @return the facility Id
     */
    public String getId() {
        return id;
    }

    /**
     * Get the  description of the facility
     * @return the facility description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the capacity of the facility
     * @return the facility capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the price of the facility
     * @return  the price in E$ for booking this facility (per hour)
     */
    public int getPrice() {
        return price;
    }
}
