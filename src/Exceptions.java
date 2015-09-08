import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

/**
 * Created by Madalin.Colezea on 9/7/2015.
 */
public class Exceptions {
    public static void main(String[] args) {
//        testMultiCatch();
//        testMultiCatchParameterAssignment();
//        try {
//            testRetrowingException();
//        } catch (SQLException | IOException e){
//            e.printStackTrace();
//        }
//        testTryWithResources();
        testSuppressedExceptions();
//        testCatchMoreExc();
    }
    private static void throwsIoExc() throws IOException{

    }
    private static void throwsSQLExc() throws SQLException{

    }

    private static void testCatchMoreExc(){
        try {
            throwsIoExc();
            throwsSQLExc();
        } catch (IOException e){

        } catch (Exception e){

        }
    }

    private static void testSuppressedExceptions(){
        class One implements AutoCloseable{
            private String name;
            public One(String name){
                this.name = name;
            }
            @Override
            public void close() throws Exception {
                throw new IOException("Closing " + name);
            }
        }

        try (One one = new One("1"); One two = new One("2")){
            throw new Exception("Exception");
        } catch (Exception e){
            System.out.println(e.getMessage());
            for (Throwable t: e.getSuppressed()){
                System.out.println("Suppressed " + t.getMessage());
            }
        }
    }

    private static void testTryWithResources(){
        try (Reader reader = new BufferedReader(new FileReader(new File("")))){
            // read from file
        } catch (Exception e){
            e.printStackTrace();
        }

        // legal si fara catch sau finally
//        File file = null;
//        try (Reader reader =
//                        new BufferedReader(new FileReader(file))) {
//        }

//    won't compile, autoclosable needed
//        try (String s = "hi") {}
    }

    private static void throwsExc() throws SQLException, IOException{}
    private static void testRetrowingException() throws SQLException, IOException{
        try {
            throwsExc();
        }catch (IOException | SQLException e){
            e.printStackTrace();
            throw e;
        }
// Nu compileaza
//        try {
//            throwsExc();
//        }catch (Exception e){
//            e.printStackTrace();
//            e = new IOException();
//            throw e;
//        }

    }

    private static void testMultiCatchParameterAssignment(){
        try {
            throw new IOException("IO");

        } catch (IOException e){
            e = new IOException();
        }
//        nu compileaza -> exceptia e final la multi-catch
//        catch (IllegalStateException | SQLException e){
//            e = new SQLException();
//        }
    }

    private static void testMultiCatch(){
        try {
            boolean x = true;
            if (x){
                throw new IOException("IO");
            }
            else {
                throw  new SQLException();
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
//        nu compileaza
//        catch (IOException e1 | IOException e2){
//            e2.printStackTrace();
//        }
//        catch (IOException | FileNotFoundException e){
//            e.printStackTrace();
//        }
    }
}
