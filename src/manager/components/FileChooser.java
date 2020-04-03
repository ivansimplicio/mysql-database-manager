package manager.components;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {

    public static String openFile(Component component) {
        JFileChooser fileChooser = createDefaultFileChooser();
        int returnValue = fileChooser.showOpenDialog(component);
        return getFilePath(returnValue, fileChooser);
    }

    public static String saveFile(Component component) {
        JFileChooser fileChooser = createDefaultFileChooser();
        int returnValue = fileChooser.showSaveDialog(component);
        return getFilePath(returnValue, fileChooser);
    }

    private static JFileChooser createDefaultFileChooser() {
        String message = "SQL Files (*.sql)";
        String defaultDirectory = "C:\\Users\\ivans\\Documents";
        FileNameExtensionFilter filter = new FileNameExtensionFilter(message, "sql");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(defaultDirectory));
        fileChooser.setFileFilter(filter);
        return fileChooser;
    }

    private static String getFilePath(int returnValue, JFileChooser fileChooser) {
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file.getAbsolutePath();
        } else {
            return "";
        }
    }
}