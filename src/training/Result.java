package training;

import java.io.File;


public class Result {

    public Result(boolean shouldExit, File workingDirectory) {
        this.shouldExit = shouldExit;
        this.workingDirectory = workingDirectory;
    }

    public boolean isShouldExit() {
        return shouldExit;
    }

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }

    private boolean shouldExit = false;

    private File workingDirectory;

    public Result(File workingDirectory) {
        this.workingDirectory = workingDirectory;
    }



    public File getWorkingDirectory() {
        return workingDirectory;
    }

    public void setWorkingDirectory(File workingDirectory){
        this.workingDirectory = workingDirectory;
    }
}
