import java.util.ArrayList;

public class Control {
    private ArrayList<Task> tasks;
    public Control() {
        String start =
                "________________________________\n"
                        + "Hello! I am Duke_two.\n"
                        + "Your Personal Assistant.\n"
                        + "What can I do for you?\n"
                        + "________________________________";
        this.tasks = new ArrayList<>();
        System.out.println(start);
    }

//    public void add(String taskStr) {
//        Task task = new Task(taskStr, false);
//        this.tasks.add(task);
//        System.out.println("________________________________");
//        System.out.println("From Duke_two: \n\tAdded to your tasks: " + task.toString());
//    }

    public void bye() {
        String bye = "GoodBye! I hope to see you again!";
        System.out.println(bye);
    }

    public void list() {
        int leng = tasks.toArray().length;
        for (int i = 0; i < leng; i++) {
            Task task = tasks.get(i);
            int num = i + 1;
            System.out.println(num + ": " + task.toString());
        }
    }

    public void taskCheck(String taskStr) {
        try{
            String[] taskArr = taskStr.split(" ");
            int index = Integer.parseInt(taskArr[1]) - 1;
            Task task = this.tasks.get(index);
            String isTaskCheck = "";
            if (taskArr[0].equals("mark")) {
                task.setChecked(true);
                System.out.println("Nice! I've marked this task as done: \n\t" + task.toString());
            } else {
                this.tasks.get(index).setChecked(false);
                System.out.println("Alright, I've marked this task as not done yet: \n\t" + task.toString());
            }
        } catch (NumberFormatException e) {
            System.out.println("An invalid task index has been inputted");
        }
    }

    public void todo(String taskStr) {
        // eg to_do borrow book (without the _)
        String[] taskArr = taskStr.split(" ", 2);
        String taskName = taskArr[1];
        ToDo task = new ToDo(taskName, false, "T");
        this.tasks.add(task);
        System.out.println("________________________________");
        System.out.println("From Duke_two: \n\tAdded to your tasks: \n\t" + task.toString());
        System.out.println("You now have " + tasks.toArray().length + " tasks in your list");
    }

    public void deadline(String taskStr) {
        // deadline return book /by Sunday
        String[] taskArr = taskStr.split(" ", 2);
        String[] taskDetails = taskArr[1].split("/by ");
        String taskName = taskDetails[0];
        String date = taskDetails[1];
        Deadline task = new Deadline(taskName, false, "D", date) ;
        this.tasks.add(task);
        System.out.println("________________________________");
        System.out.println("From Duke_two: \n\tAdded to your tasks: \n\t" + task.toString());
        System.out.println("You now have " + tasks.toArray().length + " tasks in your list");
    }

    public void event(String taskStr) {
        // event project meeting /at Mon 2-4pm
        String[] taskArr = taskStr.split(" ", 2);
        String[] taskDetails = taskArr[1].split("/at ");
        String taskName = taskDetails[0];
        String date = taskDetails[1];
        Event task = new Event(taskName, false, "E", date) ;
        this.tasks.add(task);
        System.out.println("________________________________");
        System.out.println("From Duke_two: \n\tAdded to your tasks: \n\t" + task.toString());
        System.out.println("You now have " + tasks.toArray().length + " tasks in your list");
    }


}
