package com.agfa.jenkins.ataf;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Descriptor;
import hudson.tasks.Builder;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: awpyv
 * Date: 1/07/12
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
public class TestBuilder extends Builder {

    @DataBoundConstructor public TestBuilder() {}

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
        Thread.sleep(10000);
        String xml = "\n" +
                "<testsuite name=\"com.agfa.ris.client.test.solution.workflows.qc.RemoveTaskTypeQcFromTaskAssignmentGroupRadiologistTearDown\" timestamp=\"2012-06-30T00:20:13\" errors=\"1\" failures=\"0\" skipped=\"0\" tests=\"1\" time=\"19\">\n" +
                "  <testcase classname=\"com.agfa.ris.client.test.solution.workflows.qc.RemoveTaskTypeQcFromTaskAssignmentGroupRadiologistTearDown\" name=\"tearDownRemoveTaskTypeQcFromTaskAssignmentGroupRadiologist\" time=\"19\">\n" +
                "    <system-out>java.lang.Exception: An exception occurred in com.agfa.ris.client.test.solution.smoketests.diagnostic.LoginDiagnosticTest which is a required step of Testsuite: Smoke1\n" +
                "\tat com.agfa.hap.ataf.execution.TestMojo.execute(TestMojo.java:176)\n" +
                "\tat org.apache.maven.plugin.DefaultPluginManager.executeMojo(DefaultPluginManager.java:453)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeGoals(DefaultLifecycleExecutor.java:559)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeStandaloneGoal(DefaultLifecycleExecutor.java:513)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeGoal(DefaultLifecycleExecutor.java:483)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeGoalAndHandleFailures(DefaultLifecycleExecutor.java:331)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeTaskSegments(DefaultLifecycleExecutor.java:228)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.execute(DefaultLifecycleExecutor.java:142)\n" +
                "\tat org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:336)\n" +
                "\tat org.apache.maven.DefaultMaven.execute(DefaultMaven.java:129)\n" +
                "\tat org.apache.maven.cli.MavenCli.main(MavenCli.java:301)\n" +
                "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
                "\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:597)\n" +
                "\tat org.codehaus.classworlds.Launcher.launchEnhanced(Launcher.java:315)\n" +
                "\tat org.codehaus.classworlds.Launcher.launch(Launcher.java:255)\n" +
                "\tat org.codehaus.classworlds.Launcher.mainWithExitCode(Launcher.java:430)\n" +
                "\tat org.codehaus.classworlds.Launcher.main(Launcher.java:375)</system-out>\n" +
                "  </testcase>\n" +
                "</testsuite>";
        listener.getLogger().println(xml);
        Thread.sleep(10000);
        build.getWorkspace().child("test.xml").write(xml, "UTF-8");
        xml = "\n" +
                "<testsuite name=\"com.agfa.ris.client.test.solution.smoketests.diagnostic.LoginDiagnosticTest\" timestamp=\"2012-06-30T00:20:13\" errors=\"0\" failures=\"0\" skipped=\"0\" tests=\"1\" time=\"19\">\n" +
                "  <testcase classname=\"com.agfa.ris.client.test.solution.smoketests.diagnostic.LoginDiagnosticTest\" name=\"tearDownRemoveTaskTypeQcFromTaskAssignmentGroupRadiologist\" time=\"19\">\n" +
                "    <system-out>java.lang.Exception: An exception occurred in com.agfa.ris.client.test.solution.smoketests.diagnostic.LoginDiagnosticTest which is a required step of Testsuite: Smoke1\n" +
                "\tat com.agfa.hap.ataf.execution.TestMojo.execute(TestMojo.java:176)\n" +
                "\tat org.apache.maven.plugin.DefaultPluginManager.executeMojo(DefaultPluginManager.java:453)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeGoals(DefaultLifecycleExecutor.java:559)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeStandaloneGoal(DefaultLifecycleExecutor.java:513)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeGoal(DefaultLifecycleExecutor.java:483)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeGoalAndHandleFailures(DefaultLifecycleExecutor.java:331)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeTaskSegments(DefaultLifecycleExecutor.java:228)\n" +
                "\tat org.apache.maven.lifecycle.DefaultLifecycleExecutor.execute(DefaultLifecycleExecutor.java:142)\n" +
                "\tat org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:336)\n" +
                "\tat org.apache.maven.DefaultMaven.execute(DefaultMaven.java:129)\n" +
                "\tat org.apache.maven.cli.MavenCli.main(MavenCli.java:301)\n" +
                "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
                "\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:597)\n" +
                "\tat org.codehaus.classworlds.Launcher.launchEnhanced(Launcher.java:315)\n" +
                "\tat org.codehaus.classworlds.Launcher.launch(Launcher.java:255)\n" +
                "\tat org.codehaus.classworlds.Launcher.mainWithExitCode(Launcher.java:430)\n" +
                "\tat org.codehaus.classworlds.Launcher.main(Launcher.java:375)</system-out>\n" +
                "  </testcase>\n" +
                "</testsuite>";
        listener.getLogger().println(xml);
        build.getWorkspace().child("test2.xml").write(xml,"UTF-8");

    return true;
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<Builder> {

        @Override
        public String getDisplayName() {
            return "TestBuilder";
        }
    }
}