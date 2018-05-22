package mvvPlugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;


public class MyPluginOne extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Project project = e.getData(PlatformDataKeys.PROJECT);
        String txt = Messages.showInputDialog(project,
                "你的名字是?",
                "请输入你的名字",
                Messages.getInformationIcon());

        Messages.showMessageDialog(project,
                "你好！"+txt+"\n我很高兴见到你","信息内容",Messages.getInformationIcon());
    }
//    Virtual File
//    虚拟文件类。可以当做Java开发中的File对象理解，概念比较类似
//            获取方法
//
//    通过Action获取: event.getData(PlatformDataKeys.VIRTUAL_FILE).这个也是之前教程（一）中的获取方法
//    通过本地文件路径获取: LocalFileSystem.getInstance().findFileByIoFile()
//    通过PSI file获取: psiFile.getVirtualFile()
//    通过document获取: FileDocumentManager.getInstance().getFile()

}
