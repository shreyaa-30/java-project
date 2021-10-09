import java.util.Scanner;

class LockedMeModel {
    private static final String Author = "Shreya Bhattacharjya" ;
    private static final String Application_name = "LockedMe.com" ;
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
                    // handle add file
                    handleFileOptions();
                case 2:
                    // handle delete file
                    handleFileOptions();
                case 3:
                    // handle search file
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
        System.out.println(Welcome_Message);
    }
}

public class LockedMe {
    public static void main(String[] args) {
        LockedMeModel lockedMeModel = new LockedMeModel();
        lockedMeModel.handlePrimaryMenu();
    }
}
