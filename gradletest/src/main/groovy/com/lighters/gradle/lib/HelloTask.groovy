package com.lighters.gradle.lib

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class HelloTask extends DefaultTask {

    @TaskAction
    void output() {
        println "Hello from HelloTask!!!!!"
    }
}