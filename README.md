# demo-javaprocessing-multirelease4

Simple demo for making multirelease / dualrelease jar using
https://github.com/raydac/java-comment-preprocessor

Note this is meant to be bare minimum.
It does support testing both versions, but only on the active JDK.

It should be easily adaptable for a parent pom for another project, in which case
the only modifications in the other project would be the JPC directives.

You can easily extend it for more than 2 versions, just declare another version property
and copy-paste the executions with "${mrjar.newestVersion}" in their id, changing it
to the new property.

## Goals

Make it as simple as possible, allow the user to immediately get the general idea
what it does and how.

Make it single-module.

Do not require specific version/s of JDK, just any version same or grater than
the latest version referred to in the source. Do not require any configuration
outside of the pom itself.

Avoid plugins other than widely used (no Ant-Run, no Invoker, etc). With the
exception of formatter plugin, which is not integral to making mrjar and can be
just removed.

## Basic directives

Use
```
// #excludeif target.java.version < mrjar.newestVersion

// #excludeif target.java.version >= mrjar.newestVersion
```
to exclude whole files based on current version, use
```
// #if target.java.version >= 9
System.out.println("java.version >= 9");
return getMyPidNew();
// #else
// $System.out.println("java.version < 9");
// $return getMyPidOld();
// #endif
```
for conditional compilation - note that in most cases one branch must be disabled with "//$", otherwise
IDE might get confused. Use
```
System.out.println("Compiled for version: /*$target.java.version$*/");
```
to insert the version number in the source code.

Note all classes (other than excluded by "excludeif") are compiled for both Java versions.
This shouldn't be an issue but makes the resulting jar slightly larger than it could be.

For now it was tested with Java 8 + 21 and 8 + 17.
