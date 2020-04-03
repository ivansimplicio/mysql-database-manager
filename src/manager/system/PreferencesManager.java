package manager.system;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import manager.util.File;
import manager.util.Log;
import org.apache.log4j.Logger;

public class PreferencesManager {
    
    private static final Logger LOG = Logger.getLogger(PreferencesManager.class);

    private final static String FILE_PATH = "settings.json";
    private final Gson gson = new Gson();

    private static PreferencesManager prefsInstance;
    private Preferences prefs;

    private PreferencesManager() {
        readPreferences();
    }

    public static PreferencesManager getInstance() {
        if (prefsInstance == null) {
            prefsInstance = new PreferencesManager();
        }
        return prefsInstance;
    }

    public String getHost() {
        return prefs.getHost();
    }

    public String getDatabase() {
        return prefs.getDatabase();
    }

    public String getUsername() {
        return prefs.getUsername();
    }

    public String getPassword() {
        return prefs.getPassword();
    }

    public boolean isClearTextArea() {
        return prefs.isClearTextArea();
    }

    public boolean isMultiQueries() {
        return prefs.isMultiQueries();
    }

    public String getStandardCommand() {
        return prefs.getStandardCommand();
    }
    
    private void readPreferences() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            prefs = gson.fromJson(br, Preferences.class);
        } catch (FileNotFoundException e) {
            prefs = new Preferences();
            save();
        }
    }

    public void saveLogin(String host, String database, String username, String password) {
        prefs.setHost(host);
        prefs.setDatabase(database);
        prefs.setUsername(username);
        prefs.setPassword(password);
        save();
    }

    public void savePreferences(boolean clearTextArea, boolean multiQueries, String standardCommand) {
        prefs.setClearTextArea(clearTextArea);
        prefs.setMultiQueries(multiQueries);
        prefs.setStandardCommand(standardCommand);
        save();
    }

    private void save() {
        String s = gson.toJson(prefs);
        try {
            File.Write(FILE_PATH, s);
        } catch (IOException e) {
            String path = "manager.system.PreferencesManager.save()";
            Log.saveErrorLog(LOG, e, path);
        }
    }
}