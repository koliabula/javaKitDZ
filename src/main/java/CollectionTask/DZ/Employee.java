package CollectionTask.DZ;
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
public class Employee {
    private int id, experience;

    private long numberPhone;
    private String name;

    public Employee(int id, String name, long numberPhone, int experience) {
        this.id = id;
        this.experience = experience;
        this.numberPhone = numberPhone;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public int getExperience() {
        return experience;
    }

    public Long getNumberPhone() {
        return numberPhone;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", experience=" + experience +
                ", numberPhone=" + numberPhone +
                ", name='" + name + '\'' +
                '}';
    }
}
