package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String nameDept = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int payDay = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Telefone: ");
        String phone = sc.next();

        Address address = new Address(email,phone);
        Department dept = new Department(nameDept, payDay, address);

        System.out.print("Quantos funcionários tem o departamento? ");
        int N = sc.nextInt();
        sc.nextLine();
        for(int i=1; i<=N; i++){
            System.out.println("Dados do funcionário " + i + ":");
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Salário: ");
            double salary= sc.nextDouble();
            sc.nextLine();

            Employee employee = new Employee(name, salary);
            dept.addEmployee(employee);
        }

        showReport(dept);
        sc.close();

    }
    private static void showReport(Department dept) {
        System.out.println("\nFOLHA DE PAGAMENTO:");
        System.out.printf("Departamento %s = R$ %.2f%n", dept.getName(), dept.payroll());
        System.out.printf("Pagamento realizado no dia %d%n", dept.getPayDay());
        System.out.println("Funcionários:");
        for (Employee emp : dept.getEmployees()){
            System.out.println(emp.getName());
        }
        System.out.printf("Para dúvidas favor entrar em contato: %s%n", dept.getAddress().getEmail());
    }
}
