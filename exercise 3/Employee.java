// Employee.java
class Employee extends Sortable {
    public Employee(String n, double s, int day, int month, int year) {
        name = n;
        salary = s;
        hireday = day;
        hiremonth = month;
        hireyear = year;
    }

    public void print() {
        System.out.println(name + " " + salary + " " + hireYear());
    }

    public void raiseSalary(double byPercent) {
        salary *= 1 + byPercent / 100.0;
    }

    public int hireYear() {
        return hireyear;
    }

    // ✅ Task 3.1: implement compare dari Sortable
    @Override
    public int compare(Sortable b) {
        Employee eb = (Employee) b;
        return Double.compare(this.salary, eb.salary);
    }

    private String name;
    double salary;  // sengaja tidak private supaya Manager bisa akses (atau bisa pakai getter)
    private int hireday;
    private int hiremonth;
    private int hireyear;
}
