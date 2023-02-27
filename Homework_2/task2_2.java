package Homework_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class task2_2 {
    public static void main(String[] args) {
        String file_name = "\\Homework_2\\students.txt";
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(file_name);
        File file = new File(pathFile);
        if (!file.isFile())
            System.out.printf("Фаил %s не найден.", pathFile);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile), "UTF-8"));
            while(reader.ready()) {
                String line = reader.readLine();
                line = line.replace("\"фамилия\":\"", "Студент ");
                line = line.replace("\",\"оценка\":\"", " получил оценку ");
                line = line.replace("\",\"предмет\":\"", " по предмету ");
                line = line.replace("\"", "");
                System.out.println(line);
            }

            
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
    
    
}
