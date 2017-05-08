package com.agfa.jenkins.ataf;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.model.Run;
import hudson.tasks.BuildWrapper;
import hudson.tasks.BuildWrapperDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;
import java.io.OutputStream;

public class AtafConsoleBuildWrapper extends BuildWrapper {

    @DataBoundConstructor
    public AtafConsoleBuildWrapper() {}

    @Override
    public OutputStream decorateLogger(AbstractBuild build, OutputStream logger) throws IOException, InterruptedException, Run.RunnerAbortedException {
        return new AtafTestAnnotator(logger, build.getCharset());
    }

    @Override
    public Environment setUp(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException {
        return new Environment() {};
    }

    @Extension
    public static class DescriptorImpl extends BuildWrapperDescriptor {

        @Override
        public boolean isApplicable(AbstractProject<?, ?> item) {
            return AbstractProject.class.isAssignableFrom(item.getClass());
        }

        @Override
        public String getDisplayName() {
            return "ATAF console annotator";
        }
    }

}
