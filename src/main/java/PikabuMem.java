import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;
import java.util.Random;

public class PikabuMem extends AnAction {
    public PikabuMem(){    }

    public void actionPerformed(AnActionEvent event) {
        String pikabuSite = "https://www.pikabu.ru/best/";
        Random random = new Random();
        int dateDay = random.nextInt(27) + 1;
        int dateMonth = random.nextInt(11) + 1;
        int dateYear = random.nextInt(12) + 2008;
        BrowserUtil.browse(pikabuSite + dateDay + "-" + dateMonth + "-" + dateYear);
    }
}