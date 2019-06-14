//package com.example.itc162assignment7;
//
//import java.util.ArrayList;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.os.Bundle;
//import android.widget.TextView;
//
//@SuppressLint("Registered")
//public class TaskListActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_task_list);
//        //
//        // get db and StringBuilder objects
//        TaskListDB db = new TaskListDB(this);
//        StringBuilder sb = new StringBuilder();
//
//        // insert a task
//        Task task = new Task(1, "Make dentist appointment", "", "0", "0");
//        long insertId = db.insertTask(task);
//        if (insertId > 0) {
//            sb.append("Row inserted! Insert Id: ").append(insertId).append("\n");
//        }
//
//        // insert a second task
//        Task task2 = new Task(1, "Take car in for oil change", "", "0", "0");
//        long insertId2 = db.insertTask(task2);
//        if (insertId2 > 0) {
//            sb.append("Row inserted! Insert Id: ").append(insertId2).append("\n");
//        }
//
//        Task t1 = new Task(1, "Record new album", "", "", "");
//        long i1 = db.insertTask(t1);
//        if (i1 > 0) {
//            sb.append("Row inserted! Insert Id: ").append(i1).append("\n");
//        }
//
//        Task t2 = new Task(1, "Buy new shoes", "", "", "");
//        long i2 = db.insertTask(t2);
//        if (i2 > 0) {
//            sb.append("Row inserted! Insert Id: ").append(i2).append("\n");
//        }
//
//        Task t3 = new Task(1, "Write love letters to my mentor", "", "", "");
//        long i3 = db.insertTask(t3);
//        if (i3 > 0) {
//            sb.append("Row inserted! Insert Id: ").append(i3).append("\n");
//        }
//
//        Task t4 = new Task(1, "Take my wife and crush out on dates", "", "", "");
//        long i4 = db.insertTask(t4);
//        if (i4 > 0) {
//            sb.append("Row inserted! Insert Id: ").append(i4).append("\n");
//        }
//
//        //db.execSQL("INSERT INTO task VALUES (3, 1, 'Buy new shoes', " +
//        //        "'', '0', '0')");
//        //db.execSQL("INSERT INTO task VALUES (4, 1, 'Record new album', " +
//        //        "'', '0', '0')");
//        //db.execSQL("INSERT INTO task VALUES (5, 1, 'Write love letters to my crush', " +
//        //        "'', '0', '0')");
//        //db.execSQL("INSERT INTO task VALUES (6, 1, 'Take my wife and crush out on dates', " +
//        //        "'', '0', '0')");
//
//        // update a task
//        task.setId((int) insertId);
//        task.setName("Update test");
//        int updateCount = db.updateTask(task);
//        if (updateCount == 1) {
//            sb.append("Task updated! Update count: ").append(updateCount).append("\n");
//        }
//
//        // delete a task
//        int deleteCount = db.deleteTask(insertId);
//        if (deleteCount == 2) {
//            sb.append("Task deleted! Delete count: ").append(deleteCount).append("\n\n");
//        }
//        int dC = db.deleteTask(insertId2);
//        if (dC == 2) {
//            sb.append("Task deleted! Delete count: ").append(deleteCount).append("\n\n");
//        }
//
//        // delete old tasks (this may vary from system to system)
//        //db.deleteTask(1);
//        //db.deleteTask(2);
//        //db.deleteTask(3);
//        //db.deleteTask(4);
//        //db.deleteTask(5);
//        //db.deleteTask(6);
//        //db.deleteTask(7);
//        //db.deleteTask(8);
//        //db.deleteTask(9);
//        //db.deleteTask(10);
//        //db.deleteTask(11);
//        //db.deleteTask(12);
//        //db.deleteTask(13);
//
//        // display all tasks (id + name)
//        ArrayList<Task> tasks = db.getTasks("Personal");
//        for (Task t : tasks) {
//            sb.append(t.getId()).append("|").append(t.getName()).append("\n");
//        }
//
//        // display string on UI
//        TextView taskListTextView = (TextView)
//                findViewById (R.id.taskListTextView);
//        taskListTextView.setText(sb.toString());
//    }
//}