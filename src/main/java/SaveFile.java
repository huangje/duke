import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class SaveFile {
    File file;

    public SaveFile(String file){
        this.file = new File(file);
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int readFile(Task[] task) {

        Scanner sc = null;
        try {
            sc = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int numberTasks = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split("/");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm", Locale.ENGLISH);
            switch (tokens[0]){
                case "T" :
                    if(tokens[1].equals("1")){
                        task[numberTasks] = new Todo(tokens[2], true);
                    }
                    else {
                        task[numberTasks] = new Todo(tokens[2], false);
                    }
                    break;
                case "D" :
                    String dateD = tokens[3].replace("T", " ");
                    if(tokens[1].equals("1")){
                        task[numberTasks] = new Deadline(tokens[2], LocalDateTime.parse(dateD, formatter), true);
                    }
                    else {
                        task[numberTasks] = new Deadline(tokens[2], LocalDateTime.parse(dateD, formatter), true);
                    }
                    break;
                case "E":
                    String dateE1 = tokens[3].replace("T", " ");
                    String dateE2 = tokens[4].replace("T", " ");
                    if(tokens[1].equals("1")){
                        task[numberTasks] = new Event(tokens[2], LocalDateTime.parse(dateE1, formatter), LocalDateTime.parse(dateE2, formatter), true);
                    }
                    else {
                        task[numberTasks] = new Event(tokens[2], LocalDateTime.parse(dateE2, formatter), LocalDateTime.parse(dateE2, formatter), true);
                    }
                    break;
            }
            numberTasks++;
        }
        return numberTasks;
    }

    public void writeFile(Task[] tasks, int numberTasks){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.file);
            try {

                for (int i = 0; i<numberTasks; i++) {
                    if (tasks[i].isTodo()) {
                        if (tasks[i].isDone) {
                            fileWriter.write("T/1/" + tasks[i].description + "\n");
                        } else {

                            fileWriter.write("T/0/" + tasks[i].description+ "\n");
                        }
                    } else if (tasks[i].isDeadline()) {
                        if (tasks[i].isDone) {
                            fileWriter.write("D/1/" + tasks[i].description + "/" + ((Deadline) tasks[i]).by.toString()+ "\n");
                        } else {
                            fileWriter.write("D/0/" + tasks[i].description + "/" + ((Deadline) tasks[i]).by.toString()+ "\n");
                        }
                    } else if (tasks[i].isEvent()) {
                        if (tasks[i].isDone) {
                            fileWriter.write("D/1/" + tasks[i].description + "/" + ((Event) tasks[i]).at1.toString()+ "/" + ((Event) tasks[i]).at2.toString() + "\n");
                        } else {
                            fileWriter.write("D/0/" + tasks[i].description + "/" + ((Event) tasks[i]).at1.toString()+ "/" + ((Event) tasks[i]).at2.toString() +"\n");
                        }
                    }
                }
            } finally {
                fileWriter.close();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }


    }


}
