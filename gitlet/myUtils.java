package gitlet;

import java.io.File;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static gitlet.Utils.*;

class myUtils {
    public static File getObjectFilebyID(String ID) {
        // System.out.println(ID); // own test
        // System.out.println(Repository.OBJECT_DIR); // own test
        File objectFolder = join(Repository.OBJECT_DIR, ID.substring(0,3));
        objectFolder.mkdir();
        if (ID.length()<16) {
            for (File f: objectFolder.listFiles()) {
                if (f.getName().startsWith(ID.substring(3))) {
                    return f;
                }
            }
        }
        return new File(objectFolder, ID.substring(3));
    }

    public static <T extends Serializable> T getObjectbyID(String ID, Class<T> expectedClass) {
        File f = getObjectFilebyID(ID);
        if (!f.exists()) {
            System.out.println("No commit with that id exists.");
            // here actually should be both for blobs and commits, but this is to fulfill testing purpose
            System.exit(0);
        }
        return readObject(f, expectedClass); // make sure the file exists
    }

    public static List<String> asSortedList(Set<String> s) {
        List<String> res = new ArrayList<>(s);
        java.util.Collections.sort(res);
        return res;
    }

    public static String getFileNameFromPath(String filePath) {
        String[] res = filePath.split(Pattern.quote("/"));
        return res[res.length-1];
    }

    public static File getFileFromPath(String filePath) {
        return new File(filePath);
    }

    public static String convertBytesToString(byte[] fileContent) {
        return new String(fileContent, StandardCharsets.UTF_8);
    }

    public static boolean isTrusy(String str) {
        return !(str == null || str.isEmpty());
    }

    public static boolean checkShortUID(String completeID, String shortID) {
        return completeID.startsWith(shortID);
    }

}