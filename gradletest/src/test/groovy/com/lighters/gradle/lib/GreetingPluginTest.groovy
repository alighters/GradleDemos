package com.lighters.gradle.lib

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.gradle.internal.impldep.junit.framework.TestCase.assertTrue

class GreetingPluginTest {
    @Test
    public void greeterPluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'com.lighters.gradletest'

        assertTrue(project.tasks.helloTask instanceof HelloTask)
    }
}