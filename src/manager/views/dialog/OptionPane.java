package manager.views.dialog;

import javax.swing.JOptionPane;

public class OptionPane {
    
    public static int showSelectDialog(String message){
        Object[] options = {"OK", "MAIS INFORMAÇÕES"};
        return JOptionPane.showOptionDialog(null, message, "AVISO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
    }
    
    public static void showInfoDialog(String title, String message){
        createOptionPane(title, message, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorDialog(String title, String message){
        createOptionPane(title, message, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showWarnDialog(String title, String message){
        createOptionPane(title, message, JOptionPane.WARNING_MESSAGE);
    }
    
    private static void createOptionPane(String title, String message, int messageType){
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}