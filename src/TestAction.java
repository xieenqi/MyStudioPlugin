import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.apache.http.util.TextUtils;

public class TestAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here

        // 获取project
        Project project = e.getProject();
        // 获取选中内容
        final Editor mEditor = e.getData(PlatformDataKeys.EDITOR);
        if (null == mEditor) {
            return;
        }
        SelectionModel model = mEditor.getSelectionModel();
        String selectedText = model.getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            // 未选中布局内容，显示dialog
            selectedText = Messages.showInputDialog(project, "layout（不需要输入R.layout.）：" , "未选中布局内容，请输入layout文件名", Messages.getInformationIcon());
            if (TextUtils.isEmpty(selectedText)) {
                Utils.showPopupBalloon(mEditor, "未输入layout文件名");
                return;
            }
        }
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory psiDirectory, CreateFileFromTemplateDialog.Builder builder) {
        builder.setTitle("Auto Generate")
                .addKind("Activity", PlatformIcons.CLASS_ICON, MODE_SINGLE_ACTIVITY)
                .addKind("Fragment", PlatformIcons.CLASS_ICON, MODE_FRAGMENT);
    }
}
