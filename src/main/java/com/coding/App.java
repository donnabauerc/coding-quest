package com.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class App 
{
    public static HashMap<String, LinkedList<String>> stored_questions = new HashMap<>();
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        char answer;
        System.out.println( "Welcome!" );
        System.out.println("To exit the program press e");

        do {
            String input = "";
            System.out.print("If you want to ask a question please press q. To add a new question press a: ");
            answer = sc.next().charAt(0);

            switch (answer) {
                case 'q':
                    System.out.println("Ask your question: ");
                    System.out.println(stored_questions.get("frage1").get(0));
                    break;
                case 'a':
                    sc = new Scanner(System.in);
                    System.out.print("Add your question (<question>? \"<answer1>\" \"<answer2>\" \"<answerX>\"): ");
                    input += sc.nextLine();
                    addQuestion(input);
                    break;
                case 'e':
                    break;
                default:
                    System.out.println("Sorry, unknown input!");
            }
        } while (answer != 'e');

        System.out.println("Have a nice day!");
    }

    public static void addQuestion(String input) {
        LinkedList<String> answers = new LinkedList<String>();
        String question = input.split("\\?")[0];
        String[] answer_part = input.split("\\?")[1].split("\"");

        for (int i = 0; i < answer_part.length; i++) {
            if (i%2 != 0) {
                answers.push(answer_part[i]);
            }
        }

        System.out.println("Question: " + question);
        stored_questions.put(question, answers);
    }

    public static ArrayList<String> evaluateAnswers(String question) {
        return null;
    }
}
