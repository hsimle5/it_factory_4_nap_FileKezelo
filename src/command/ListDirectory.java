package command;

import training.Command;
import training.CommandException;
import training.Result;

import java.io.File;


public class ListDirectory implements Command {
    @Override
    public boolean shouldHandle(String command) {
        return command.equals("ls");
    }

    @Override
    public Result process(File workingDirectory, String command) throws CommandException {

        for (File file : workingDirectory.listFiles()){
            System.out.println(" " + file.getName());
            if(file.isDirectory()){
                System.out.print(" <dir>");
            }
            else if (file.isFile()) {System.out.print(" <file>");}
        }

        return new Result(workingDirectory);
    }
}
