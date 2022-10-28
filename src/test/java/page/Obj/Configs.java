package page.Obj;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Configs {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    static {
        try {
            //config path
            fileInputStream = new FileInputStream("src/test/TestResources/Configs");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //exception preocessing
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace(); } } }
    /**
     * config vars load
     */
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key); } }