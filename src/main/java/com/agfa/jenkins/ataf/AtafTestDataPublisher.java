package com.agfa.jenkins.ataf;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.tasks.junit.TestDataPublisher;
import hudson.tasks.junit.TestResult;
import hudson.tasks.junit.TestResultAction;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

public class AtafTestDataPublisher extends TestDataPublisher {

    @DataBoundConstructor
    public AtafTestDataPublisher() {}

    @Override
    public TestResultAction.Data getTestData(AbstractBuild<?, ?> abstractBuild, Launcher launcher, BuildListener buildListener, TestResult testResult) throws IOException, InterruptedException {
        return AtafTestData.INSTANCE;
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<TestDataPublisher> {

        @Override
        public String getDisplayName() {
            return "ATAF test hyperlinking";
        }
    }


}
