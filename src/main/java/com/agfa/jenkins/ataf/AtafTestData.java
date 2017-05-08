package com.agfa.jenkins.ataf;

import hudson.tasks.junit.TestAction;
import hudson.tasks.junit.TestObject;
import hudson.tasks.junit.TestResultAction;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: awpyv
 * Date: 1/07/12
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public class AtafTestData extends TestResultAction.Data {

    public static final AtafTestData INSTANCE = new AtafTestData();

    public Object readResolve() {
        return INSTANCE;
    }

    @Override
    public List<? extends TestAction> getTestAction(TestObject testObject) {
        return Collections.singletonList(AtafTestDataAction.INSTANCE);
    }
}
