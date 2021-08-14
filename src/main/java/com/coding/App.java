package com.coding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class App 
{
    public static HashMap<String, LinkedList<String>> stored_questions = new HashMap<>();
    public static void main( String[] args )
    {
        char choice;
        Scanner sc = new Scanner(System.in);
        System.out.println( "Welcome!" );
        System.out.println("To exit the program press e");

        do {
            String input = "";
            System.out.print("If you want to ask a question please press q. To add a new question press a: ");
            choice = sc.next().charAt(0);

            sc = new Scanner(System.in);
            switch (choice) {
                case 'q':
                    System.out.print("Ask your question: ");
                    input = sc.nextLine();
                    try {
                        stored_questions.get(input).forEach(a -> System.out.println(a));
                    } catch (Exception e) {
                        System.out.println("The answer to life, universe and everything is 42");
                    }

                    break;
                case 'a':
                    System.out.print("Add your question (<question>? \"<answer1>\" \"<answer2>\" \"<answerX>\"): ");
                    input = sc.nextLine();
                    addQuestion(input);
                    break;
                case 'e':
                    break;
                default:
                    System.out.println("Sorry, unknown input!");
            }
        } while (choice != 'e');

        System.out.println("Have a nice day!");
    }

    public static void addQuestion(String input) { //TODO: Check Question Format
        LinkedList<String> answers = new LinkedList<String>();
        String question = input.split("\\?")[0];
        question = input.substring(0, input.indexOf("?") + 1);
        String[] answer_part = input.split("\\?")[1].split("\"");

        for (int i = 0; i < answer_part.length; i++) {
            if (i%2 != 0) {
                answers.push(answer_part[i]);
            }
        }

        stored_questions.put(question, answers);
    }
}
