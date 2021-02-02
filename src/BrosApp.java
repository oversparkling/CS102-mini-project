public class BrosApp {
    /* This is the starting point of the program.
       The BrosApp class creates a new BrosMenu object
       and calls the execute() method of the BrosMenu object,
       where the entire program is run from. */
       
    public static void main(String[] args) {
        BrosMenu menu = new BrosMenu();
        menu.execute();
    }

}
