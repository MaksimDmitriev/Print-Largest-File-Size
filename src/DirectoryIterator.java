import com.sun.istack.internal.NotNull;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Maksim on 1/12/2016.
 */
public class DirectoryIterator {

    private DirectoryIterator() {
        throw new AssertionError();
    }

    public static String getLargestFilePath(@NotNull File initPath) {
        long maxFileLength = 0;
        String maxFilePath = null;
        Deque<File> stack = new ArrayDeque<>();
        stack.push(initPath);
        while (!stack.isEmpty()) {
            File current = stack.pop();
            if (current.isDirectory()) {
                File[] files = current.listFiles();
                for (File file : files) {
                    stack.push(file);
                }
            } else if (current.length() > maxFileLength) {
                maxFilePath = current.getAbsolutePath();
            }
        }
        return maxFilePath;
    }

}
