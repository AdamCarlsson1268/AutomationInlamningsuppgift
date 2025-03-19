package todo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        TodoList todoList = new TodoList();
        todoList.addTask("Köpa mjölk");
        todoList.addTask("Betala räkningar");

        System.out.println("Todolista:");
        System.out.println(todoList.getList());


        System.out.println("Bocka av saker ifrån listan genom att skriva respektive siffra (1 eller 2) för uppgiften och trycka Enter");
        int value = -1;
        try {
            value = Integer.parseInt(scan.nextLine()) - 1;
        } catch (Exception e) {
            System.out.println("Inkorrekt värde");
        }
        System.out.println();
        todoList.completeTask(value);

        System.out.println("Uppdaterad Todolista:");
        System.out.println(todoList.getList());
    }
}

