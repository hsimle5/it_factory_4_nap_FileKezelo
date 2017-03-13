package command;

import training.Command;
import training.CommandException;
import training.Result;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public class Catenate  implements Command{

    public static final String CAT = "cat ";

    @Override
    public boolean shouldHandle(String command) {
        return command.startsWith(CAT);
    }

    @Override
    public Result process(File workingDirectory, String command) throws CommandException {

        String fileName = command.substring(CAT.length());
        File file = new File(workingDirectory,fileName);
        if(!file.exists() || !file.isFile() || !file.canRead()){
            throw new CommandException("Invalid file" + fileName);
        }

        List<String> lines = null;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new CommandException("Nem olvasható fájl:" + fileName);
        }
        for (String line: lines) {
            System.out.println(line);
        }

        return new Result(workingDirectory);
    }
}
