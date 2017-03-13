package command;

import training.Command;
import training.CommandException;
import training.Result;

import java.io.File;

/**
 * Created by soma on 2017.03.10..
 */
public class PrintWorkingDirectory implements Command {
    @Override
    public boolean shouldHandle(String command) {
        return "pwd".equals(command);
    }

    @Override
    public Result process(File workingDirectory, String command) throws CommandException {
        System.out.println(workingDirectory.getAbsolutePath());
        return new Result(workingDirectory);
    }
}
