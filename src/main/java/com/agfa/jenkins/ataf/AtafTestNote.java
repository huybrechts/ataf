package com.agfa.jenkins.ataf;

import hudson.Extension;
import hudson.MarkupText;
import hudson.console.ConsoleNote;
import hudson.console.ConsoleAnnotationDescriptor;
import hudson.console.ConsoleAnnotator;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public final class AtafTestNote extends ConsoleNote {
    public AtafTestNote() {
    }

    @Override
    public ConsoleAnnotator annotate(Object context, MarkupText text, int charPos) {
        // still under development. too early to put into production
        if (!ENABLED)   return null;

        boolean success = text.getText().contains("errors=\"0\"") && text.getText().contains("failures=\"0\"");
        String successClass = success ? "ataf-test-success" : "ataf-test-failure";

        MarkupText.SubText t = text.findToken(Pattern.compile("name=\"(.*?)\""));
        if (t!=null) {
            t = t.subText(6, t.length() - 1);
            String test = t.getText();
            StringTokenizer st = new StringTokenizer(test, ".");
            StringBuilder shortTest = new StringBuilder();
            String token = null;
            while (st.hasMoreTokens()) {
                if (shortTest.length() > 0) shortTest.append(".");
                token = st.nextToken();
                shortTest.append(token.charAt(0));
            }
            shortTest.append(token.substring(1));
            t.addMarkup(0,t.length(),"<b class='ataf-test " + successClass + "' test=\'" + shortTest + "\'>","</b>");
        }
        return null;
    }

    @Extension
    public static final class DescriptorImpl extends ConsoleAnnotationDescriptor {
        public String getDisplayName() {
            return "Ant targets";
        }
    }

    public static boolean ENABLED = !Boolean.getBoolean(AtafTestNote.class.getName()+".disabled");
}
