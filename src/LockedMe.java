import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

class LockedMeModel {
    private static final String Author = "Shreya Bhattacharjya" ;
    private static final String Application_name = "LockedMe.com" ;
    File project_directory = new File("files");
    private static final String Welcome_Message = "+++++  " + Application_name + " +++++\n" +
                                                   "++++ " + Author + "++++\n" ;

    private static final String primary_screen = "LockedMe Menu. Select an option:\n" +
                                "1. List file in sorted order.\n" +
                                "2. File Options. \n" +
                                "3. Exit. \n";

    private static final String file_options_screen = "File Options Menu. Select an option:\n" +
                                "1.Add new file.\n" +
                                "2.Delete file.\n" +
                                "3.Search file.\n" +
                                "4.Back.\n";

    void addFile() throws IOException {
        System.out.print("Enter filename > ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        File newFile = new File(project_directory + "/" + filename);
        if(newFile.exists() == true) {
            System.out.println("File: "+ filename +" already exists");
            return;
        }
        newFile.createNewFile();
        System.out.println("File "+ filename + " added.");
    }

    void deleteFile() throws IOException {
        System.out.print("Enter filename > ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        File newFile = new File(project_directory + "/" + filename);
        if(!newFile.exists()) {
            System.out.println("File: "+ filename +" doesn't exist.");
            return;
        }
        newFile.delete();
        System.out.println("File "+ filename + " deleted.");
    }

    void searchFile() throws IOException {
        System.out.print("Enter filename > ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        File newFile = new File(project_directory + "/" + filename);
        if(newFile.exists()) {
            System.out.println("File: "+ filename +" exists");
        } else {
            System.out.println("File: " + filename + " not present.");
        }
    }

    void handlePrimaryMenu() {
        System.out.println(primary_screen);
        try {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch(input) {
                case 1:
                    handlePrimaryMenu();
                case 2:
                    handleFileOptions();
                case 3:
                    System.out.println("Exiting Application...");
                    System.exit(0);
                default: handlePrimaryMenu();
            }
        } catch (Exception e) {
            handlePrimaryMenu();
        }
    }

    void handleFileOptions() {
        System.out.println(file_options_screen);
        try {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    addFile();
                    handleFileOptions();
                case 2:
                    deleteFile();
                    handleFileOptions();
                case 3:
                    searchFile();
                    handleFileOptions();
                case 4:
                    handlePrimaryMenu();
                default: handleFileOptions();
            }
        } catch (Exception e) {
            handleFileOptions();
        }
    }

    LockedMeModel() {
        if(project_directory.exists() == false) {
            project_directory.mkdirs();
        }
        System.out.println(Welcome_Message);
    }
}

public class LockedMe {
    public static void main(String[] args) {
        LockedMeModel lockedMeModel = new LockedMeModel();
        lockedMeModel.handlePrimaryMenu();
    }
}
