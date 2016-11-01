package com.lighters.gradle.lib

import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPluginExtension {
    String message
    String greeter
}

class GreetingPluginNestedExtension {
    String to
}

class GreetingPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.gradle.addListener(new TimeListener())
        project.extensions.create("greeting", GreetingPluginExtension)
        project.greeting.extensions.create("to", GreetingPluginNestedExtension)
        project.task('hello') << {
            println "${project.greeting.message} from ${project.greeting.greeter} to ${project.greeting.to.to}"
            println "hello"
        }
        project.task("helloTask", type: HelloTask)
    }
}


//task test111{
//    println "test113"
//    println getProject().getGradle().getTaskGraph()
//    println getProject()
//    println getProject().android
//}
//
//afterEvaluate {
//    println("-------------afterEvaluate-----------------")
//    for(variant in getProject().android.applicationVariants){
//        println(variant)
//        println(variant.getDirName())
//        println(variant.getDescription())
//        println(variant.getAssemble())
//        println(variant.getVersionName())
//        println(variant.buildType)
//        println(variant.buildType.getMultiDexEnabled())
//    }
//}
//
//// Extensions are just plain objects, there is no interface/type
//class MyExtension {
//    String foo
//
//    MyExtension(String foo) {
//        this.foo = foo
//    }
//}
//
//// Add new extensions via the extension container
//project.extensions.create('custom', MyExtension, "bar")
////                       («name»,   «type»,       «constructor args», …)
//
//// extensions appear as properties on the target object by the given name
//assert project.custom instanceof MyExtension
//assert project.custom.foo == "bar"
//
//// also via a namespace method
//project.custom {
//    assert foo == "bar"
//    foo = "other"
//}
//assert project.custom.foo == "other"
//
//// Extensions added with the extension container's create method are themselves extensible
//assert project.custom instanceof ExtensionAware
//project.custom.extensions.create("nested", MyExtension, "baz")
//assert project.custom.nested.foo == "baz"
//
//// All extension aware objects have a special “ext” extension of type ExtraPropertiesExtension
//assert project.hasProperty("myProperty") == false
//project.ext.myProperty = "myValue"
//
//// Properties added to the “ext” extension are promoted to the owning object
//assert project.myProperty == "myValue"
//
//
//project.ext.set("myProp", "myValue")
//assert project.myProp == "myValue"
//
//project.myProp = "anotherValue"
//assert project.myProp == "anotherValue"
//assert project.ext.get("myProp") == "anotherValue"
//
//project.ext {
//    myprop = "a"
//}
//assert project.myprop == "a"
//assert project.ext.myprop == "a"
//
//project.myprop = "b"
//assert project.myprop == "b"
//assert project.ext.myprop == "b"
//
//project.ext["otherProp"] = "a"
//assert project.otherProp == "a"
//assert project.ext["otherProp"] == "a"


