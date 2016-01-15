
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class DirectoryIteratorTest {

    private String mTestDir = "C:\\Users\\Maksim\\Downloads\\Test" + File.separatorChar;

    @Test
    public void singleFileIsInit() {
        File initPath = new File(mTestDir + "Android_Accelerometer.png");
        Assert.assertEquals(initPath.getAbsolutePath(), DirectoryIterator.getLargestFilePath(initPath));
    }

    @Test
    public void onlyDirs() {
        File initPath = new File(mTestDir + "only_dirs");
        Assert.assertEquals(null, DirectoryIterator.getLargestFilePath(initPath));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPath() {
        Assert.assertEquals(null, DirectoryIterator.getLargestFilePath(null));
    }

    @Test
    public void emptyPath() {
        File initPath = new File("");
        Assert.assertEquals(null, DirectoryIterator.getLargestFilePath(initPath));
    }

    // C:\Users\Maksim\Google Drive\Books\Algorithms\ Algorithms_and_Data_Structures_RU 281 777
    @Test
    public void manyFiles() {
        File initPath = new File("C:\\Users\\Maksim\\Google Drive");
        Assert.assertEquals("C:\\Users\\Maksim\\Google Drive\\Books\\Algorithms\\Algorithms_and_Data_Structures_RU.mp4", DirectoryIterator.getLargestFilePath(initPath));
    }

}
