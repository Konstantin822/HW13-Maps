package homework;


import java.util.*;

public class FileNavigator {
    private static Map<String, List<FileData>> fileByPath;

    public FileNavigator() {
        fileByPath = new HashMap<>();
    }

    public void add(FileData file) {
        String path = file.getPath();
        if (!fileByPath.containsKey(path)) {
            fileByPath.put(path, new ArrayList<>());
        }
        List<FileData> files = fileByPath.get(path);
        if (!files.contains(files)) {
            files.add(file);
        }
    }

    public static List<FileData> find(String path) {
        return fileByPath.getOrDefault(path, new ArrayList<>());
    }

    public static List<FileData> filterBySize(int maxSize) {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> files : fileByPath.values()) {
            for (FileData file : files) {
                if (maxSize >= file.getSize())
                    result.add(file);
            }
        }
        return result;
    }

    public void remove(String path) {
        fileByPath.remove(path);
        System.out.println("Path: " + path + " has been removed");
    }

    public static List<FileData> sortBySize() {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> files : fileByPath.values()) {
            result.addAll(files);
        }
        Collections.sort(result, Comparator.comparing(FileData::getSize));
        return result;
    }

    public void consistencyCheck(FileData file) {
        String path = file.getPath();
        if (!path.equals(pathKey(path))) {
            System.out.println("Error. " + path + " does not match the key path " + pathKey(path));
        }
    }

    public String pathKey(String key) {
        int i = key.lastIndexOf("s");
        if (i == -1) {
            return "";
        } else {
            return key.substring(0, i);
        }
    }
}
