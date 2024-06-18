package CollectionTask.DZ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Создать справочник сотрудников
 * Необходимо:
 * Создать класс справочник сотрудников, который содержит внутри
 * коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
 * Табельный номер
 * Номер телефона
 * Имя
 * Стаж
 * Добавить метод, который ищет сотрудника по стажу (может быть список)
 * Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
 * Добавить метод, который ищет сотрудника по табельному номеру
 * Добавить метод добавления нового сотрудника в справочник
 */
public class EmployeeDirectory {
    private int id;


    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(String name, long numberPhone, int experience) {
        id++;
        if (testNumber(numberPhone)) {
            Employee employee = new Employee(id, name, numberPhone, experience);
            employeeList.add(employee);
        } else {
            System.out.println("Сотрудник с таким НОМЕРОМ ТЕЛЕФОНА: (" +
                    numberPhone + ") уже существует");
        }
    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    private boolean testNumber(long numberPhone) {
        for (Employee e : employeeList) {
            if (e.getNumberPhone() == numberPhone) {
                return false;
            }
        }
        return true;
    }


    //Добавить метод, который ищет сотрудника по стажу (может быть список)
    public List<Employee> searchToExperience(int experience) {
        List<Employee> employeeList1 = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.getExperience() == experience) employeeList1.add(e);
        }
        return employeeList1;
    }


    //    Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
    public HashMap<Long, String> searchPhoneByName(String name) {
        HashMap<Long, String> phoneList = new HashMap<>();
        for (Employee e : employeeList) {
            if (e.getName().toLowerCase().equals(name.toLowerCase().trim())) phoneList.put(e.getNumberPhone(), name);
        }
        return phoneList;
    }

    // Добавить метод, который ищет сотрудника по табельному номеру
    public Employee searchEmployeeByID(int id) {
        List<Employee> phoneList = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.getId() == id) return e;
        }
        return null;
    }
}
