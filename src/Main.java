import java.util.Random;

    public class Main {
        private static final Employee[] EMPLOYEES = new Employee[10];


        public static void main(String[] args) {
            fillEmployees();
            printFullInfo();
            System.out.println("Сумма ЗП: " + totalSalaries());
            System.out.println("Сотрудник с мин ЗП: " + findEmployeeWithMinSalary());
            System.out.println("Сотрудник с макс ЗП: " + findEmployeeWithMaxSalary());
            System.out.println("Средняя ЗП: " + findAverageSalary());
            printFullNameInfo();

            int indexPercent = 10;
            indexSalary(10);
            System.out.printf("ЗП после индексации на %d%%%n", indexPercent);
            printFullInfo();

            int department = 3;
            System.out.printf("Сотрудник с мин ЗП из департамента %d: %s%n",
                    department, findEmployeeWithMinSalary(department));
            System.out.printf("Сотрудник с макс ЗП из департамента %d: %s%n",
                    department, findEmployeeWithMaxSalary(department));
            System.out.printf("Сумма ЗП по отделу %d: %d%n",
                    department, totalSalaries(department));
            System.out.printf("Средняя ЗП по отделу %d: %.2f%n", department, findAverageSalary(department));

            indexSalary(indexPercent, department);
            System.out.printf("ЗП после индексации на %d%% сотрудников отдела %d%n", indexPercent, department);
            printFullInfo();
            printFullInfo(department);
            int salary = 70_000;
            printEmployeesWithSalaryLessThan(salary);
            printEmployeesWithSalaryGreatThan(salary);

        }


        private static void fillEmployees() {
            Random random = new Random();
            for (int i = 0; i < EMPLOYEES.length; i++) {
                EMPLOYEES[i] = new Employee(
                        "Сотрудник " + (i + 1),
                        random.nextInt(1, 6),
                        random.nextInt(45_000, 90_000)
                );
            }


        }
        /*базовая сложность*/

        private static void printFullInfo() {
            System.out.println("Все сотрудники");
            for (Employee employee : EMPLOYEES) {
                System.out.println(employee);
            }

        }

        private static int totalSalaries() {

            int sum = 0;
            for (Employee employee : EMPLOYEES) {
                sum += employee.getSalary();
            }
            return sum;

        }

        private static Employee findEmployeeWithMinSalary() {
            int min = Integer.MAX_VALUE;
            Employee employee = null;
            for (Employee emp : EMPLOYEES) {
                if (emp.getSalary() < min) {
                    min = emp.getSalary();
                    employee = emp;
                }
            }
            return employee;
        }

        private static Employee findEmployeeWithMaxSalary() {
            int max = Integer.MIN_VALUE;
            Employee employee = null;
            for (Employee emp : EMPLOYEES) {
                if (emp.getSalary() > max) {
                    max = emp.getSalary();
                    employee = emp;
                }
            }
            return employee;
        }

        private static double findAverageSalary() {
            return totalSalaries() / (double) EMPLOYEES.length;
        }

        private static void printFullNameInfo() {
            System.out.println("ФИО всех сотрудников");
            for (Employee employee : EMPLOYEES) {
                System.out.println(employee.getFullName());
            }

        }

        /*повышенная сложность*/
        private static void indexSalary(int percent) {
            double coeff = 1 + percent / 100D;
            for (Employee employee : EMPLOYEES) {
                employee.setSalary((int) (employee.getSalary() * coeff));

            }

        }

        private static Employee findEmployeeWithMinSalary(int department) {
            int min = Integer.MAX_VALUE;
            Employee employee = null;
            for (Employee emp : EMPLOYEES) {
                if (emp.getSalary() < min && emp.getDepartment() == department) {
                    min = emp.getSalary();
                    employee = emp;
                }
            }
            return employee;
        }

        private static Employee findEmployeeWithMaxSalary(int department) {
            int max = Integer.MIN_VALUE;
            Employee employee = null;
            for (Employee emp : EMPLOYEES) {
                if (emp.getSalary() > max && emp.getDepartment() == department) {
                    max = emp.getSalary();
                    employee = emp;
                }
            }
            return employee;
        }

        private static int totalSalaries(int department) {
            int sum = 0;
            for (Employee employee : EMPLOYEES) {
                if (employee.getDepartment() == department) {
                    sum += employee.getSalary();
                }
            }
            return sum;

        }

        private static double findAverageSalary(int department) {
            int count = 0;
            int sum = 0;
            for (Employee employee : EMPLOYEES) {
                if (employee.getDepartment() == department) {
                    sum += employee.getSalary();
                    count++;
                }
            }
            if (count != 0) {
                return sum / (double) count;
            } else {
                return 0;
            }
        }

        private static void indexSalary(int percent, int department) {
            double coeff = 1 + percent / 100D;
            for (Employee employee : EMPLOYEES) {
                if (employee.getDepartment() == department) {
                    employee.setSalary((int) (employee.getSalary() * coeff));
                }

            }

        }

        private static void printFullInfo(int department) {
            System.out.println("Сотрудники отдела " + department);
            for (Employee employee : EMPLOYEES) {
                if (employee.getDepartment() == department) {
                    System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
                }
            }

        }

        private static void printEmployeesWithSalaryLessThan(int salary) {
            System.out.println("Сотрудники отдела с ЗП меньше, чем  " + salary);
            for (Employee employee : EMPLOYEES) {
                if (employee.getSalary() < salary) {
                    System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
                }
            }

        }

        private static void printEmployeesWithSalaryGreatThan(int salary) {
            System.out.println("Сотрудники отдела с ЗП больше, чем  " + salary);
            for (Employee employee : EMPLOYEES) {
                if (employee.getSalary() > salary) {
                    System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
                }
            }

        }
    }


