import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class BrosDate {
    private Date dateTime;

    public BrosDate() {
        this.dateTime = new Date();
    }

    public BrosDate(String var1) {
        SimpleDateFormat var2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            this.dateTime = var2.parse(var1);
        } catch (ParseException var4) {
            var4.printStackTrace();
        }


    }

    private Date getDateTime() {
        return this.dateTime;
    }

    private void setDateTime(Date var1) {
        this.dateTime = var1;
    }

    public boolean equals(BrosDate var1) {
        return this.dateTime.equals(var1.getDateTime());
    }

    public boolean after(BrosDate var1) {
        return this.dateTime.after(var1.getDateTime());
    }

    public boolean before(BrosDate var1) {
        return this.dateTime.before(var1.getDateTime());
    }

    public  BrosDate computeDate(int var1) {
        GregorianCalendar var2 = new GregorianCalendar();
        var2.setTime(this.dateTime);

        try {
            var2.add(11, var1);
        } catch (IllegalArgumentException var4) {
            var4.printStackTrace();
        }
        BrosDate var3 = new BrosDate();
        var3.setDateTime(var2.getTime());
        return var3;
    }

    public String toString() {
        SimpleDateFormat var1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return var1.format(this.dateTime);
    }
}