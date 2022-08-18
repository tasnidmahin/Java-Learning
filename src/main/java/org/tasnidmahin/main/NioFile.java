package org.tasnidmahin.main;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Date;
import java.util.List;

public class NioFile {
    public void run() {
        try {
            Path dirPath = Paths.get("DataSet");
            if(Files.exists(dirPath)){
                System.out.println("Directory already exists");
            } else {
                Path p = Files.createDirectories(dirPath);
                System.out.println("Directory created at " + p.toString());
            }

            Path filePath = Paths.get("DataSet/poem.txt");
            if(Files.exists(filePath)){
                System.out.println("File already exists");
            } else {
                Path p = Files.createFile(filePath);
                System.out.println("File created at " + p.toString());
            }

            List<String> data = Files.readAllLines(filePath);
            for(String line:data) {
                System.out.println(line);
            }

            writeFile();

            System.out.println("Started: " + new Date());
            Path source = Paths.get("Code.rar");
            Path destination = Paths.get("Dataset/pasted.rar");
            Files.copy(source, destination);
            System.out.println("Completed: " + new Date());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(){
        try {
            Path filePath = Paths.get("DataSet/test.txt");
            if(!Files.exists(filePath)) {
                filePath = Files.createFile(filePath);
            }

            String content = "Hello World";
            Files.write(filePath, content.getBytes(StandardCharsets.UTF_8));
            System.out.println("Data written as array");


            Path filePath2 = Paths.get("DataSet/test2.txt");
            if(!Files.exists(filePath2)) {
                filePath2 = Files.createFile(filePath2);
            }
            Path path3 = Paths.get("DataSet/poem.txt");
            List<String> data = Files.readAllLines(path3);

            Files.write(filePath2, data);

            System.out.println("Data written using list of string");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
