package com.agfa.jenkins.ataf;

import hudson.Functions;
import hudson.MarkupText;
import hudson.tasks.junit.ClassResult;
import hudson.tasks.junit.PackageResult;
import hudson.tasks.junit.TestAction;
import hudson.tasks.junit.TestDataPublisher;
import hudson.tasks.junit.TestResult;
import hudson.tasks.junit.TestResultAction;
import org.kohsuke.stapler.Stapler;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtafTestDataAction extends TestAction {

    public static final AtafTestDataAction INSTANCE = new AtafTestDataAction();

    public Object readResolve() {
        return INSTANCE;
    }

    public String getIconFileName() {
        return null;
    }

    public String getDisplayName() {
        return null;
    }

    public String getUrlName() {
        return null;
    }

    @Override
    public String annotate(String text) {
        Pattern p = Pattern.compile("(\\S*\\.\\S*Test)");
        MarkupText t = new MarkupText(text);
        List<MarkupText.SubText> tokens = t.findTokens(p);
        for (MarkupText.SubText token: tokens) {
            int sp = token.getText().indexOf(' ');
            MarkupText.SubText test = token.subText(0, sp);
            String url = getTestURL(test.getText());
            if (url != null) {
                test.surroundWithLiteral("<a href=\"" + url + "\">", "</a>");
            }
        }
        return t.toString(true);
    }

    private String getTestURL(String test) {
        TestResult action = Stapler.getCurrentRequest().findAncestorObject(TestResult.class);
        int i = test.lastIndexOf('.');
        if (i <= 0) return null;
        String packageName = test.substring(0, i);
        String className = test.substring(i + 1);
        PackageResult pk = action.byPackage(packageName);
        if (pk == null) return null;
        ClassResult ck = pk.getClassResult(className);
        if (ck == null) return null;
        return Functions.getRelativeLinkTo(action.getParentAction().owner.getProject()) + "/" + action.getParentAction().owner.getNumber() + "/testReport" + ck.getUrl();
    }
}
