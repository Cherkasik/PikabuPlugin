import javax.swing.*;

/**
 * Интерфейс браузера
 */
public interface BrowserView {
    public void init();
    public void load(String url);
    public void reload();
    public JComponent getNode();
}
