package com.coding;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

// Note: I know these test don't work, couldn't figure out a :|
// also I don't really have much experience writing Tests 

public class AppTest 
{
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setupOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private void provideMultipleInputs(String[] data) {
        String finalDataString = "";
        for (String s : data) {
            finalDataString += s + System.lineSeparator();
        }
        System.setIn(new ByteArrayInputStream(finalDataString.getBytes()));
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testExit() {
        provideInput("e");
        App.main(null);
        assertThat(App.stored_questions.size()).isEqualTo(0);
    }
/*
    @Test
    public void addQuestion() {
        String[] input = {"a", "Funktioniert die Testfrage? \"Ja, sie funktioniert\"", "e"};
        provideMultipleInputs(input);
        App.main(null);
        assertThat(App.stored_questions.size()).isEqualTo(1);
    }

  @Test
    public void askUnknownQuestion() {
        String[] input = {"q", "Funktioniert die Testfrage?", "e"};
        provideMultipleInputs(input);
        App.main(null);
        String out = getOutput();
        assertThat(out).isEqualTo("++++++++ Welcome! ++++++++\n
                                    To exit the program press e\n
                                    \n
                                    If you want to ask a question please press q. To add a new question press a: q\n
                                    Ask your question: Funktioniert die Testfrage?\n
                                    The answer to life, universe and everything is 42\n
                                    \n
                                    If you want to ask a question please press q. To add a new question press a: e\n
                                    Have a nice day!");
    }

    @Test
    public void askKnownQuestion() {
        String[] input = {"a", "Funktioniert die Testfrage?  \"Ja, sie funktioniert\"", "q", "Funktioniert die Testfrage?", "e"};
        provideMultipleInputs(input);
        App.main(null);
        String out = getOutput();
        assertThat(out).isEqualTo(" ++++++++ Welcome! ++++++++\n
                                    To exit the program press e\n
                                    \n
                                    If you want to ask a question please press q. To add a new question press a: a\n
                                    Add your question (<question>? "<answer1>" "<answer2>" "<answerX>"): Funktioniert die Testfrage? "Ja, sie funktioniert"\n
                                    \n
                                    If you want to ask a question please press q. To add a new question press a: q\n
                                    Ask your question: Funktioniert die Testfrage?\n
                                    Ja, sie funktioniert\n
                                    \n
                                    If you want to ask a question please press q. To add a new question press a: e\n
                                    Have a nice day!"); 
    } 
    */

}
