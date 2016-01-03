import jodd.io.findfile.FindFile;
import jodd.util.ObjectUtil;
import model.User;
import org.junit.Test;

import java.io.File;

/**
 * Created by CHANEL on 2016/1/3.
 */
public class JoddTest {

    @Test
    public void testFindFile(){
        FindFile findFile = new FindFile();
        findFile.setIncludeDirs(true).setRecursive(true).setIncludeFiles(true);
        String path = System.getProperty("user.home");
        findFile.searchPath(path);
        File f;
        while((f = findFile.nextFile()) != null){
            if(f.isDirectory())
                System.out.println(".>" + f.getName());
            else
                System.out.println("." + f.getName());
        }
    }
}
