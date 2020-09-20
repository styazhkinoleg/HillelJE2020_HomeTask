package lesson_17;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Ошибка передачи параметра 1");
        } else {
            File inputFile = new File(args[0]);
            if(inputFile.exists()) {
                String str = "";
                Path path = Path.of(args[0]);
                try {
                    str = new String(Files.readAllBytes(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String fullFileName = path.getFileName().toString();
                String fileName = fullFileName.substring(0, fullFileName.lastIndexOf('.'));
                String outputFile = "";
                if(fullFileName.endsWith(".json")) {
                    outputFile = fileName + ".yml";
                    str = Converter.jsonToYaml(str);
                } else if (fullFileName.endsWith(".yml")) {
                    outputFile = fileName + ".json";
                    str = Converter.yamlToJson(str);
                } else {
                    System.out.println("Не поддерживаемый формат");
                    return;
                }
                try {
                    Files.write(Path.of(path.getParent().toString().concat("/").concat(outputFile)), str.getBytes(), StandardOpenOption.CREATE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else
                System.out.println("Не найден " + args[0]);
        }
    }
}
