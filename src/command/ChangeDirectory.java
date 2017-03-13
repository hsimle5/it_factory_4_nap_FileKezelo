package command;


import training.Command;
import training.CommandException;
import training.Result;

import java.io.File;

/**
 * Created by soma on 2017.03.10..
 */
public class ChangeDirectory implements Command{


    @Override
    public boolean shouldHandle(String command) {
            return command.startsWith("cd ");
    }


    @Override
    public Result process(File workingDirectory, String command) throws CommandException {
        String arg = command.substring("cd ".length());
        File newDir;
        if("..".equals(arg)){
            newDir = workingDirectory.getParentFile();
        } else {
            newDir = new File(workingDirectory, arg);
        }
        if(newDir == null || !newDir.exists() || !newDir.isDirectory()){
            throw new CommandException("nem lesz jo:" + arg);
        }
        return new Result(newDir);
    }
}
