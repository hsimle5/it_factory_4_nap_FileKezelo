package command;

import training.Command;
import training.CommandException;
import training.Result;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public class PrintBinary implements Command {

    public static final String PRINT_BINARY_COMMAND = "pb ";
    public static final int COUNT_CHARS_PER_LINES = 8;

    @Override
    public boolean shouldHandle(String command) {
        return command.startsWith(PRINT_BINARY_COMMAND);
    }

    @Override
    public Result process(File workingDirectory, String command) throws CommandException {

        String fileName = command.substring(PRINT_BINARY_COMMAND.length());
        File file = new File(workingDirectory,fileName);
        if(!file.exists() || !file.isFile() || !file.canRead()){
            throw new CommandException("Invalid file" + fileName);
        }

        try {
            byte[] content =  Files.readAllBytes(file.toPath());
            int count = 1;
            for (byte currentByte : content) {
                System.out.print(String.format("%3d",content));
                System.out.print("");
                if(count % COUNT_CHARS_PER_LINES == 0){
                    System.out.println();
                }
            }
        } catch (IOException e) {
            throw new CommandException("Nem olvasható fájl:" + fileName);
        }


        return new Result(workingDirectory);
    }
}
