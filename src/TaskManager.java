import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

class Task {
    private String description;
    private boolean isDone;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone(){
        this.isDone = true;
    }

    public String getDescription(){
        return description;
    }

    public boolean isDone(){
        return isDone;
    }

    @Override
    public String toString(){
        String check = isDone ? "[X]" : "[ ]";
        return check + " " + description;
    }

}

public class TaskManager{

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        loadTasks();

        int option;
        do {
            System.out.println("\n=== To-Do List ===");
            System.out.println("1 - Add Task");
            System.out.println("2 - List Tasks");
            System.out.println("3 - Quit and Save");
            System.out.println("4 - Complete Task");
            System.out.println("5 - Remove Task");
            System.out.println("Option: ");

            option = sc.nextInt();
            sc.nextLine();

            if (option == 1){
                System.out.println("Add the description of task: ");
                String description = sc.nextLine();

                tasks.add(new Task(description));
                System.out.println("Task Added");
            }
            else if (option == 2) {
                System.out.println("\n--- Your Tasks ---");
                if (tasks.isEmpty()){
                    System.out.println("The list is empty");
                } else {
                    for (int i = 0; i < tasks.size(); i++){
                        System.out.println(i + " - " + tasks.get(i));
                    }
                }
            }
            else if (option == 3){
                System.out.println("Saving and quit...");
                saveTasks();
            }
            else if (option == 4){
                System.out.println("Write the number of task");
                int number = sc.nextInt();

                if (number >= 0 && number < tasks.size()){
                    Task t = tasks.get(number);
                    t.markAsDone();
                    System.out.println("Task marked as done! ");
                } else {
                    System.out.println("Invalid task number! ");
                }
            }
            else if (option == 5){
                System.out.println("Write the number of task");
                int number = sc.nextInt();
                sc.nextLine();

                if (number >= 0 && number < tasks.size()){
                    Task t = tasks.remove(number);
                    System.out.println("Task removed with success!");
                } else {
                    System.out.println("Invalid task number! ");
                }
            }
            else {
                System.out.println("The option is invalid.");
            }

        } while (option != 3);
    }

    public static void saveTasks(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"))){

            for (Task task : tasks) {

                String line = task.getDescription() + ";" + task.isDone();

                writer.write(line);
                writer.newLine();

            }
            System.out.println("Data successfully saved to 'tasks.txt'!");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    public static void loadTasks(){
        File file = new File("tasks.txt");

        if (!file.exists()){
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;

            while ((line = reader.readLine()) != null){
                String[] parts = line.split(";");

                String description = parts[0];
                boolean isDone = Boolean.parseBoolean(parts[1]);

                Task task = new Task(description);
                    if (isDone){
                        task.markAsDone();
                    }
                    tasks.add(task);
            }
            System.out.println("Tasks loading with success!");
        } catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

}



