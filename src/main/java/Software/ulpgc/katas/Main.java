package Software.ulpgc.katas;

import Software.ulpgc.katas.IO.EmployeeReader;
import Software.ulpgc.katas.IO.URLEmployeeReader;
import Software.ulpgc.katas.model.Employee;

import java.io.*;
import java.net.URL;
import java.util.List;

public class Main {
    static void main() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Employee%20Dataset%20-%20TSV.txt");
        EmployeeReader reader = new URLEmployeeReader((url));
        List<Employee> employees = reader.readAll();
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }
}
