package training;

import java.io.File;


public interface Command {

    boolean shouldHandle(String command);

    Result process(File workingDirectory, String command) throws CommandException;

}
