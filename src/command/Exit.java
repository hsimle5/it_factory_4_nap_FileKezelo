package command;

import training.Command;
import training.CommandException;
import training.Result;

import java.io.File;
import java.io.SyncFailedException;


public class Exit implements Command {

    @Override
    public boolean shouldHandle(String command) {
        return "exit".equals(command);
    }

    @Override
    public Result process(File workingDirectory, String command) throws CommandException {
        return new Result(false, workingDirectory);
    }
}
