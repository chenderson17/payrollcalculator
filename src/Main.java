import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Employee{
    private int employeeId;
    private String name;
    private double hoursRate;
    private double payRate;
    Employee(int employeeId, String name, double hoursRate, double payRate){
        this.employeeId = employeeId;
        this.name = name;
        this.hoursRate = hoursRate;
        this.payRate = payRate;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public double getGrossPay(){
        return payRate;
    }
}
public class Main {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("employee.csv");
            BufferedReader bufReader = new BufferedReader(reader);
            String text;
            ArrayList<Employee> employees = new ArrayList<>();
            while((text = bufReader.readLine()) != null){
                String[] parts = text.split("\\|");
                System.out.println(Arrays.toString(parts));
                employees.add(new Employee(Integer.valueOf(parts[0]), parts[1],Double.valueOf(parts[2]),Double.parseDouble(parts[3])));
            }
            bufReader.close();
            for(Employee employee : employees){
                System.out.printf("Employee ID: %d | Gross Pay Rate: $%.2f\n",employee.getEmployeeId(), employee.getGrossPay());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //input form: id|name|hours-worked|pay-rate

    }
}