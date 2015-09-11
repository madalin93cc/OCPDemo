import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Madalin.Colezea on 9/10/2015.
 */
public class DateExamples {
    public static void main(String[] args) {
        testDate();
        testCallendar();
        dateFormatTest();
        localeTest();
        testNumberFormat();
    }

    private static void testDate(){
        Date date = new Date(); // current date
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(date.toInstant());
        System.out.println(date.before(new Date(1990, 1, 1)));

        Date date2 = new Date(1_000_000_000_000L);
        System.out.println("date: " + date2);
        date2.setTime(date2.getTime() + 3_600_000);
        System.out.println("new date: " + date2);
    }

    private static void testCallendar(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        Date d = new Date(1_000_000_000_000L);
        System.out.println("Date: " + d);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        if (Calendar.SUNDAY == c.getFirstDayOfWeek()){
            System.out.println("Day of week: " + c.DAY_OF_WEEK);
            System.out.println("Day of week in month: " + c.DAY_OF_WEEK_IN_MONTH);
        }
        c.add(Calendar.MONTH, 1);
        Date d2 = c.getTime();
        System.out.println("Date 2: " + d2.toString());

        c.roll(Calendar.MONTH, 10);
        System.out.println("Roll date: " + c.getTime());
    }

    private static void dateFormatTest(){
        Date d = new Date(1_000_000_000_000L);
        DateFormat[] df = new DateFormat[6];
        df[0] = DateFormat.getInstance();
        df[1] = DateFormat.getDateInstance();
        df[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        df[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        df[4] = DateFormat.getDateInstance(DateFormat.LONG);
        df[5] = DateFormat.getDateInstance(DateFormat.FULL);

        for (DateFormat df1: df){
            System.out.println(df1.format(d));
        }

        String s = df[0].format(d);
        System.out.println("Formated: " + s);
        try {
            Date d2 = df[0].parse(s);
            System.out.println(d2);
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    public static void localeTest(){
        Calendar c = Calendar.getInstance();
        c.set(2011, 10, 10);
        Date d = c.getTime();

        Locale [] loc = new Locale[5];
        loc[0] = new Locale("it", "IT");
        loc[1] = new Locale("pt");
        loc[2] = new Locale("pt", "BR");
        loc[3] = new Locale("hi", "IN");
        loc[4] = new Locale("ja");

        DateFormat f1 = DateFormat.getInstance();
        System.out.println(f1.format(d));

        DateFormat f2 = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(f2.format(d));

        DateFormat f3 = DateFormat.getDateInstance(DateFormat.FULL, loc[0]);
        System.out.println(f3.format(d));

        DateFormat f4 = DateFormat.getDateInstance(DateFormat.FULL, loc[1]);
        System.out.println(f4.format(d));

        DateFormat f5 = DateFormat.getDateInstance(DateFormat.FULL, loc[2]);
        System.out.println(f5.format(d));

        DateFormat f6 = DateFormat.getDateInstance(DateFormat.FULL, loc[3]);
        System.out.println(f6.format(d));

        DateFormat f7 = DateFormat.getDateInstance(DateFormat.FULL, loc[4]);
        System.out.println(f7.format(d));


        Locale locBR = new Locale("pt", "BR"); // Brazil
        Locale locDK = new Locale("da", "DK"); // Denmark
        Locale locIT = new Locale("it", "IT");
        System.out.println("def " + locBR.getDisplayCountry());
        System.out.println("loc " + locBR.getDisplayCountry(locBR));
        System.out.println("def " + locDK.getDisplayLanguage());
        System.out.println("loc " + locDK.getDisplayLanguage(locDK));
        System.out.println("D>I " + locDK.getDisplayLanguage(locIT));
    }

    private static void testNumberFormat(){
        float f = 123.4567f;
        Locale loc = new Locale("fr");
        NumberFormat[] nfs = new NumberFormat[4];

        nfs[0] = NumberFormat.getInstance();
        nfs[1] = NumberFormat.getInstance(loc);
        nfs[2] = NumberFormat.getCurrencyInstance();
        nfs[3] = NumberFormat.getCurrencyInstance(loc);

        for (NumberFormat nf: nfs){
            System.out.println(nf.format(f));
        }

        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.getMaximumFractionDigits());
        System.out.println(nf.format(f));
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(f));

        try {
            System.out.println(nf.parse("1234.567"));
            nf.setParseIntegerOnly(true);
            System.out.println(nf.parse("1234.567"));

        } catch (ParseException e){
            e.printStackTrace();
        }
    }

}
