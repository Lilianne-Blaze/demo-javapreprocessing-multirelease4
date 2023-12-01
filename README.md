# demo-javaprocessing-multirelease4

Simple demo for making multirelease / dualrelease jar using https://github.com/raydac/java-comment-preprocessor

Note this is meant to be bare minimum.
It does support testing both versions, but only on the active JDK.

It should be easily adaptable for a parent pom for another project, in which case
the only modifications in the other project would be the JPC directives.

You can easily extend it for more than 2 versions, just declare another version property
and copy-paste the executions with "${mrjar.newestVersion}" in their id, changing it
to the new property.

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
for conditional compilation - note that in most cases one branch must be disabled, otherwise
IDE might get confused. Use
```
System.out.println("Compiled for version: /*$target.java.version$*/");
```
to insert the version number in the source code.

Note all classes (other than excluded by "excludeif") are compiled for both Java versions.
This shouldn't be an issue but makes the resulting jar slightly larger than it could be.

For now it was tested with Java 8+21 and 8+17.
