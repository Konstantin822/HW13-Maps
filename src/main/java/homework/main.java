package homework;

import java.util.List;

public class main {
    public static void main(String[] args) {
        FileData fileData1 = new FileData("text1.txt", 1000, "/bladf/IdeaProjects/Maps");
        FileData fileData2 = new FileData("text2.txt", 2000, "/bladf/IdeaProjects/Maps");
        FileData fileData3 = new FileData("text3.txt", 500, "/bladf/IdeaProjects/Maps");
        FileData fileData4 = new FileData("text4.txt", 400, "/path/to/file");
        FileData fileData5 = new FileData("text5.txt", 300, "/path/to/file");

        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add(fileData1);
        fileNavigator.add(fileData2);
        fileNavigator.add(fileData3);
        fileNavigator.add(fileData4);
        fileNavigator.add(fileData5);

        List<FileData> files = fileNavigator.find("/bladf/IdeaProjects/Maps");
        for (FileData fileData : files) {
            System.out.println("Files in /bladf/IdeaProjects/Maps: " + fileData.getName());
        }

        System.out.println();

        List<FileData> filteredBySize = fileNavigator.filterBySize(1000);
        for (FileData fileData : filteredBySize) {
            System.out.println(fileData.getName() + " - " + fileData.getSize() + " bytes");
        }

        System.out.println();

        fileNavigator.remove("/bladf/IdeaProjects/Maps");

        System.out.println();

        List<FileData> sortedBySize = fileNavigator.sortBySize();
        for (FileData fileData : sortedBySize) {
            System.out.println(fileData.getName() + " - " + fileData.getSize() + " bytes");
        }

        System.out.println();

        fileNavigator.consistencyCheck(fileData3);
    }
}
