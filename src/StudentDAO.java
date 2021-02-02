import java.util.ArrayList;

/**
 * The StudentDAO is in charge of the Student objects in the system.
 */
public class StudentDAO {
    private ArrayList<Student> studentList;

    /**
     * Constructs a StudentDAO object.
     * with the initial list of Students (refer to project writeup)
     *
     */
    public StudentDAO() {

        studentList = new ArrayList<>();
        this.studentList.add(new Student("raini","Rainie Yang",20));
        this.studentList.add(new Student("hyun", "Hyun Bin", 30));
        this.studentList.add(new Student("aaron", "Aaron Yang", 40));
        this.studentList. add(new Student("simi", "Shiela Sim",50));
        // initialize the sample data
    }

    /**
     * Retrieves all the student objects.
     * <br />
     * This method should only be used to list all students. If you need
     * to retrieve a specific student, use the retrieve(String) method.
     * @return the list of students
     */
    public ArrayList<Student> retrieveAll() {
        if (studentList.size() == 0){
            return null;
        }
        else{
            return studentList;
        }
        
    }

    /**
     * Adds a specific Student into the system
     * @param username the username of the new user
     * @param name the full name of the new user
     * @param eDollars the initial balance of the new user
     */
    public void add(String username, String name, int eDollars) {
    
        this.studentList.add(new Student(username,name,eDollars));

    }

    /**
     * retrieves a student with the specified username
     * @param username the username of the student that you are searching for
     * @return the Student object if found. Otherwise, return null.
     */
    public Student retrieve(String username) {
        for (int i = 0; i < studentList.size(); i ++){
            Student check = this.studentList.get(i);
            if (check.getUsername().equals(username)){
                return check;
            }
        }
        return null;
    }

}
