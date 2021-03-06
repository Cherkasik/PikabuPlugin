import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.openapi.wm.ex.ToolWindowManagerEx;
import com.intellij.openapi.wm.ex.ToolWindowManagerListener;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Tool Window Factory
 */
public class BrowserWindow implements ToolWindowFactory {

    /**
     *  Constructor
     */
    public BrowserWindow() {

    }

    /**
     * @param project Project
     * @param toolWindow ToolWindow
     */
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {

        final ToolWindowManager manager = ToolWindowManager.getInstance(project);

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(new BrowserPanel(new JavaFxBrowserView()),"", false);
        toolWindow.getContentManager().addContent(content);
        toolWindow.getContentManager().getComponent().addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {}
            public void componentMoved(ComponentEvent e) { }
            public void componentShown(ComponentEvent e) {}
            public void componentHidden(ComponentEvent e) {}
        });

        final ToolWindowManagerListener listener = new ToolWindowManagerListener() {
            public void toolWindowRegistered(String id) {}
            public void stateChanged() {}
        };

        toolWindow.show(() -> ((ToolWindowManagerEx) manager).addToolWindowManagerListener(listener));
    }
}
