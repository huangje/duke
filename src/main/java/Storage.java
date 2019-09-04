import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Storage {
    File file;

    public Storage(String file){
        this.file = new File(file);
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> load() {

        Scanner sc = null;
        try {
            sc = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Task> tasks = new ArrayList<>();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split("/");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm", Locale.ENGLISH);
            switch (tokens[0]){
                case "T" :
                    if(tokens[1].equals("1")){
                        tasks.add(new Todo(tokens[2], true));
                    }
                    else {
                        tasks.add(new Todo(tokens[2], false));
                    }
                    break;
                case "D" :
                    String dateD = tokens[3].replace("T", " ");
                    if(tokens[1].equals("1")){
                        tasks.add(new Deadline(tokens[2], LocalDateTime.parse(dateD, formatter), true));
                    }
                    else {
                        tasks.add(new Deadline(tokens[2], LocalDateTime.parse(dateD, formatter), true));
                    }
                    break;
                case "E":
                    String dateE1 = tokens[3].replace("T", " ");
                    String dateE2 = tokens[4].replace("T", " ");
                    if(tokens[1].equals("1")){
                        tasks.add(new Event(tokens[2], LocalDateTime.parse(dateE1, formatter), LocalDateTime.parse(dateE2, formatter), true));
                    }
                    else {
                        tasks.add(new Event(tokens[2], LocalDateTime.parse(dateE2, formatter), LocalDateTime.parse(dateE2, formatter), true));
                    }
                    break;
            }
        }
        return tasks;
    }

    public void save(ArrayList<Task> tasks){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.file);
            try {

                for (Task task : tasks){
                    if (task.isTodo()) {
                        if (task.isDone) {
                            fileWriter.write("T/1/" + task.description + "\n");
                        } else {

                            fileWriter.write("T/0/" + task.description+ "\n");
                        }
                    } else if (task.isDeadline()) {
                        if (task.isDone) {
                            fileWriter.write("D/1/" + task.description + "/" + ((Deadline) task).by.toString()+ "\n");
                        } else {
                            fileWriter.write("D/0/" + task.description + "/" + ((Deadline) task).by.toString()+ "\n");
                        }
                    } else if (task.isEvent()) {
                        if (task.isDone) {
                            fileWriter.write("D/1/" + task.description + "/" + ((Event) task).at1.toString()+ "/" + ((Event) task).at2.toString() + "\n");
                        } else {
                            fileWriter.write("D/0/" + task.description + "/" + ((Event) task).at1.toString()+ "/" + ((Event) task).at2.toString() +"\n");
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
