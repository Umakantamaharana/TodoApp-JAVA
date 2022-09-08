package com.todo.single;

import java.util.ArrayList;
import java.util.Scanner;

public class Todo {
    static class TodoList {
        String title = "BLANK_TITLE";
        String desc = "Description";
        String completed = "(INCOMPLETE)";
        ArrayList<Object> todoList = new ArrayList<>();
        Scanner inp = new Scanner(System.in);

        void read() {
            ArrayList<Object> newList = new ArrayList<>();
            System.out.println("Enter todo name : ");
            this.title = inp.nextLine();
            System.out.println("Enter it's description : ");
            this.desc = inp.nextLine();
            newList.add(this.title);
            newList.add(this.desc);
            newList.add(this.completed);
            todoList.add(newList);
        }

        void show() {
            if (todoList.isEmpty()) {
                System.out.println("\nCurrently you don't have any thing to do. Create a todo by entering 1.\n");
            }
            System.out.println("LIST");
            int sl_no = 0;
            for (Object o : todoList) {
                sl_no = sl_no + 1;
                System.out.print("-------------\n" + sl_no + ".");
                for (Object t : (ArrayList<Object>) o) {
                    System.out.print(t + "\n  ");
                }
            }
            System.out.println("\r-------------\nEOF\n-------------");
        }

        public void modify() {
            if (todoList.isEmpty()) {
                System.out.println("\nCurrently you don't have any thing to do. Create a todo by entering 1.\n");
            } else {
                System.out.println("Enter the serial no : ");
                int sln = inp.nextInt();
                if (sln > todoList.size()) {
                    System.out.println("You have only " + todoList.size() + " number of todos.");
                } else {
                    ArrayList<Object> modObj = (ArrayList<Object>) todoList.get(sln - 1);
                    System.out.println(modObj);
                    System.out.println("===========\nWhat do you want to change\n===========\n1. Title,\n2. Description");
                    System.out.println("Enter a number : ");
                    int n = inp.nextInt();
                    inp.nextLine();
                    switch (n) {
                        case 1 -> {
                            System.out.println("Enter the new title : ");
                            String modified = inp.nextLine();
                            modObj.set(0, modified);
                        }
                        case 2 -> {
                            System.out.println("Enter the new description : ");
                            String modified = inp.nextLine();
                            modObj.set(1, modified);
                        }
                    }
                }
            }
        }

        public void mark_complete() {
            if (todoList.isEmpty()) {
                System.out.println("\nCurrently you don't have any thing to do. Create a todo by entering 1.\n");
            } else {
                System.out.println("Enter the serial no : ");
                int sln = inp.nextInt();
                if (sln > todoList.size()) {
                    System.out.println("You have only " + todoList.size() + " number of todos.");
                } else {
                    ArrayList<Object> modObj = (ArrayList<Object>) todoList.get(sln - 1);
                    modObj.set(2, "(COMPLETED)");
                }
            }
        }
        public void delete(){
            if (todoList.isEmpty()) {
                System.out.println("\nCurrently you don't have any thing to do. Create a todo by entering 1.\n");
            } else {
                System.out.println("Enter the serial no : ");
                int sln = inp.nextInt();
                if (sln > todoList.size()) {
                    System.out.println("You have only " + todoList.size() + " number of todos.");
                } else {
//                    ArrayList<Object> modObj = (ArrayList<Object>) todoList.get(sln - 1);
                    todoList.remove(sln - 1);

                }
            }
        }
    }

    public static void main(String[] args) {
        String command;
        System.out.println("=========== Todo App ===========");
        TodoList myTodo = new TodoList();
        do {
            System.out.println("-------------");
            Scanner cin = new Scanner(System.in);

            if (myTodo.todoList.isEmpty()){
                System.out.println("1.New\n2.Quit");
                System.out.println("-------------");
                System.out.println("What do you want to do : ");
                command = cin.nextLine();
                switch (command) {
                    case "1" -> {
                        myTodo.read();
                        myTodo.show();
                    }
                    case "2" -> {
                        command = "6";
                        System.out.println("Quitting..");
                    }
                    default -> System.out.println("===========\nEnter a valid number.\n===========");
                }
            }
            else {
                System.out.println("1.New\n2.Show\n3.Modify\n4.Mark complete\n5.Delete\n6.Quit");
                System.out.println("-------------");
                System.out.println("What do you want to do : ");
                command = cin.nextLine();
                switch (command) {
                    case "1" -> {
                        myTodo.read();
                        myTodo.show();
                    }
                    case "2" -> myTodo.show();
                    case "3" -> {
                        myTodo.modify();
                        myTodo.show();
                    }
                    case "4" -> {
                        myTodo.mark_complete();
                        myTodo.show();
                    }
                    case "5" -> {
                        myTodo.delete();
                        myTodo.show();
                    }
                    case "6" -> System.out.println("Quitting..");
                    default -> System.out.println("===========\nEnter a valid number.\n===========");
                }
            }
        } while (!command.equals("6"));
    }
}
