package training;

import command.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    private Command[] availableCommands = new Command[] {new ChangeDirectory(), new PrintWorkingDirectory(), new Exit(), new Catenate(), new PrintBinary(), new ListDirectory()};

    private Result result = new Result(new File("").getAbsoluteFile());

    public static void main(String[] args) throws IOException {
        new Program().start();
    }

    private void start() throws IOException {
        greet();
        while (!result.isShouldExit()) {
            String commandText = readLine();
            processCommandText(commandText);
        }
    }



    private void processCommandText(String commandText) {
        boolean isHandled = false;
        for (int i = 0; i < availableCommands.length && !isHandled; i++) {
            Command currentCommand = availableCommands[i];
            isHandled = tryAvailableCommand(commandText, currentCommand);
        }
    }

    private boolean tryAvailableCommand(String commandText, Command currentCommand) {
        boolean isHandled = false;
        if(currentCommand.shouldHandle(commandText)){
            processCurrentCommand(commandText, currentCommand);
            isHandled= true;
        }
        return isHandled;
    }

    private void processCurrentCommand(String commandText, Command currentCommand) {
        try {
            result = currentCommand.process(result.getWorkingDirectory(), commandText);
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
    }


    private void greet() {
        System.out.println("JavaCommander v0.1");
        System.out.println("Aktuális könyvtár: " + result.getWorkingDirectory());
        System.out.println("Írd be mit akarsz:");
    }

    private String readLine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

}
