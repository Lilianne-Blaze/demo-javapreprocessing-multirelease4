package demo4;

import org.junit.jupiter.api.Test;

// #excludeif target.java.version < 21
public class Lib21Test {

    @Test
    public void testJavaVersions() {
        System.out.println("Current Java version: " + System.getProperty("java.runtime.version"));
        System.out.println("Compiled for version: /*$target.java.version$*/");
    }

    @Test
    public void testGetMyPids21() {
        System.out.println("Java version = " + System.getProperty("java.runtime.version"));
        // System.out.println("Java classpath = " + System.getProperty("java.class.path"));
        System.out.println("My pid = " + Lib.getMyPid());
        System.out.println("My pid old = " + Lib.getMyPidOld());
        System.out.println("My pid new = " + Lib.getMyPidNew());
    }

}
