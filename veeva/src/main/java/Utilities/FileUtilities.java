package Utilities;

public class FileUtilities {

    public synchronized static String abs(String path){
        return System.getProperty("user.dir") +"/"+ path;
    }

    public synchronized static String totalPath(String path1, String path2){
        return path1.endsWith("/") ? path1 + path2 : path1 + "/" + path2;
    }

    public synchronized static String totalAbsPath(String path1, String path2){
        return abs(totalPath(path1, path2));
    }
}
