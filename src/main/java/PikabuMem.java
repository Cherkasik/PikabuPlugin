import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;
import java.util.Random;

public class PikabuMem extends AnAction {
    public PikabuMem() {
        super(null, null, new ImageIcon(PikabuMem.class.getClassLoader().getResource("icon/pikabu.png")));
    }

    public void actionPerformed(AnActionEvent event) {
        String pikabuSite = "https://www.pikabu.ru/best/";
        Random random = new Random();
        int dateDay = random.nextInt(29) + 1;
        int dateMonth = random.nextInt(13) + 1;
        int dateYear = random.nextInt(2020) + 2008;
        BrowserUtil.browse(pikabuSite + dateDay + "-" + dateMonth + "-" + dateYear);
    }
}