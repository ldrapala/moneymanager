package byt.money.moneymanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Lukasz
 */
public class LocalizerService {

    private final List<LocalizerListener> listeners;

    public LocalizerService() {
        listeners = new ArrayList<>();
    }

    public void localize(String language) {
        Locale.setDefault(new Locale(language));
        notifyListeners();
    }

    private void notifyListeners() {
        for (LocalizerListener listener : listeners) {
            listener.localize();
        }
    }

    public void registerListener(LocalizerListener listener) {
        listeners.add(listener);
    }

    public void unregisterListener(LocalizerListener listener) {
        listeners.remove(listener);
    }

}
