package mvvPlugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiMethod;

public class MyPluginTwo extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
//        getFileChild(e);
        getClassMethout(e);
    }

    private void getFileChild(AnActionEvent e) {
        PsiFile project = e.getData(PlatformDataKeys.PSI_FILE);
        for (PsiElement ELE : project.getChildren()) {
            System.out.print(ELE);
        }

    }

    private void getClassMethout(AnActionEvent e) {
        PsiFile file = e.getData(PlatformDataKeys.PSI_FILE);
        for (PsiElement psiElement : file.getChildren()) {
            if (psiElement instanceof PsiClass) {
                PsiClass clazz = (PsiClass) psiElement;
                PsiMethod method = clazz.getMethods()[0];
                System.out.println(method.getName());
                System.out.println(method.getParameterList().getText());
            }
        }
    }

//    PSI File
//    PSI系统下的文件类。
//    获取方法
//
//    通过Action获取: e.getData(LangDataKeys.PSI_FILE).
//    通过VirtualFile获取: PsiManager.getInstance(project).findFile()
//    通过document获取: PsiDocumentManager.getInstance(project).getPsiFile()
//    通过文件中的Element元素获取: psiElement.getContainingFile()如果要通过名字获取，请使用 FilenameIndex.getFilesByName(project, name, scope)
//
//    用处
//    作为PSI系统中的一个元素，可以使用PSI Element的各种具体方法

}
