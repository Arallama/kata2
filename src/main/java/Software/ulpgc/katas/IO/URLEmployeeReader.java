package Software.ulpgc.katas.IO;

import Software.ulpgc.katas.model.Employee;
import Software.ulpgc.katas.model.Gender;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLEmployeeReader implements EmployeeReader{

    private final URL url;

    public URLEmployeeReader(URL url) {
        this.url = url;
    }

    @Override
    public List<Employee> readAll() {
        try{
            return loadFrame(url);
        } catch (Exception e){
            return List.of();
        }
    }

    private List<Employee> loadFrame(URL url) throws IOException{
        try(InputStream inputStream = url.openStream()){
            return loadFrame(inputStream);
        }
    }

    private List<Employee> loadFrame(InputStream inputStream) throws IOException{
        return loadFrame(new InputStreamReader(inputStream));
    }

    private List<Employee> loadFrame(Reader reader) throws IOException {
        return loadFrame(reader.readAllLines());
    }

    private List<Employee> loadFrame(List<String> lines) {
        ArrayList<Employee> list = new ArrayList<>();
        for (int i = 1; i< lines.size(); i++){
            list.add(toEmployee(lines.get(i)));
        }
        return list;
    }

    private Employee toEmployee(String line) {
        return toEmployee((line.split("\t")));
    }

    private Employee toEmployee(String[] fields) {
        return new Employee(fields[0], toGender(fields[5]));
    }

    private Gender toGender(String field) {
        if(field.isEmpty()) return null;
        return Gender.valueOf(field);
    }
}
