package lesson_22;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

public class LoggerExample implements Runnable{
    private ArrayList<String> messages;
    private File file;

    public LoggerExample() {
        String nameLogFile = "log.txt";
        String currentDirectory = null;
        try {
            currentDirectory = this.getClass().getResource(".").toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        initialization(currentDirectory + nameLogFile);
    }
    public LoggerExample(String logFilePath) {
        initialization(logFilePath);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                break;
            } finally {
                saveMessages();
            }
        }
    }

    public void write(String message){
        messages.add(message);
    }

    private void initialization(String logFilePath) {
        messages = new ArrayList<>();
        file = new File(logFilePath);
    }
    private void saveMessages() {
        try {
            saveLog();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveLog() throws IOException, FileNotFoundException {
        if (messages.isEmpty()) return;
        FileOutputStream outStreamFile = null;
        outStreamFile = new FileOutputStream(file, file.exists());
        while (!messages.isEmpty()) {
            outStreamFile.write(String.format("\n%s | %s", new Date().toString(), messages.get(0)).getBytes());
            messages.remove(0);
        }
        outStreamFile.close();
    }
}