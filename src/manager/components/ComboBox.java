package manager.components;

import java.util.List;
import javax.swing.JComboBox;

public class ComboBox {

    public static void load(JComboBox<String> comboBox, List<String> items, boolean firstEmptyItem) {
        comboBox.removeAllItems();
        if (firstEmptyItem) {
            comboBox.addItem("");
        }
        for (int i = 0; i < items.size(); i++) {
            comboBox.addItem(items.get(i));
        }
    }
}