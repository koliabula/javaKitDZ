package CollectionTask.DZ;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();

        employeeDirectory.addEmployee("Наталья", 375298118130L, 5);
        employeeDirectory.addEmployee("Николай", 375336110312L, 10);
        employeeDirectory.addEmployee("Алина", 375337110312L, 10);
        employeeDirectory.addEmployee("Рубен", 375336110312L, 17);
        employeeDirectory.addEmployee("Сергей", 375338964258L, 19);
        employeeDirectory.addEmployee("Михаил", 375298754589L, 21);
        employeeDirectory.addEmployee("Наталья", 375298100130L, 25);


        System.out.println(employeeDirectory.searchToExperience(10));

        System.out.println(employeeDirectory.searchPhoneByName(" наталья"));

        System.out.println(employeeDirectory.searchEmployeeByID(6));
    }
}
