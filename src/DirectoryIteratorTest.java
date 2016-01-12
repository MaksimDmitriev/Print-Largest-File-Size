
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class DirectoryIteratorTest {

    private String mTestDir = "C:\\Users\\Maksim\\Downloads\\Test";

    @Test
    public void initFile() {
        File initPath = new File(mTestDir + File.separatorChar + "Android_Accelerometer.png");
        Assert.assertEquals(initPath.getAbsolutePath(), DirectoryIterator.getLargestFilePath(initPath));
    }
}
