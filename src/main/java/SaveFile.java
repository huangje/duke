import java.io.*;
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
                    if(tokens[1].equals("1")){
                        task[numberTasks] = new Deadline(tokens[2], tokens[3], true);
                    }
                    else {
                        task[numberTasks] = new Deadline(tokens[2], tokens[3], true);
                    }
                    break;
                case "E":
                    if(tokens[1].equals("1")){
                        task[numberTasks] = new Event(tokens[2], tokens[3], true);
                    }
                    else {
                        task[numberTasks] = new Event(tokens[2], tokens[3], true);
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
                            fileWriter.write("D/1/" + tasks[i].description + "/" + ((Deadline) tasks[i]).by+ "\n");
                        } else {
                            fileWriter.write("D/0/" + tasks[i].description + "/" + ((Deadline) tasks[i]).by+ "\n");
                        }
                    } else if (tasks[i].isEvent()) {
                        if (tasks[i].isDone) {
                            fileWriter.write("D/1/" + tasks[i].description + "/" + ((Event) tasks[i]).at+ "\n");
                        } else {
                            fileWriter.write("D/0/" + tasks[i].description + "/" + ((Event) tasks[i]).at+ "\n");
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
