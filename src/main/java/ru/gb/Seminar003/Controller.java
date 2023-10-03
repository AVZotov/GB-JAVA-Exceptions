package ru.gb.Seminar003;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public void run(){
        System.out.print("""
                To save person to file please enter person's credentials using following pattern:
                Lastname Firstname Secondname dd.mm.yyyy XXXXXXXXXXX f""");
        String userInput;

        while (true){
            System.out.print("\nEnter your patter here: ");
            userInput = getUserInput();
            Parser parser = new Parser(userInput);

            try {
                Person person = parser.getPerson();

                if (person != null){
                    FileIO fileIO = new FileIO(person.getLastName());
                    fileIO.save(person.toString());
                }
                else throw new ParserError("Error in imputed string parsing!");
                return;
            } catch (ParserError | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getUserInput(){
        Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
    }
}
