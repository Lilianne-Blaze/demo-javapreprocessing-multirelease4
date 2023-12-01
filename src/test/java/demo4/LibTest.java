package demo4;

import org.junit.jupiter.api.Test;

public class LibTest {

    @Test
    public void testJavaVersions() {
        System.out.println("[LibTest] Current Java version: " + System.getProperty("java.runtime.version"));
        System.out.println("[LibTest] Compiled for version: /*$target.java.version$*/");
    }

    @Test
    public void testGetMyPids() {
        System.out.println("[LibTest] Java version = " + System.getProperty("java.runtime.version"));
        System.out.println("[LibTest] Java classpath = " + System.getProperty("java.class.path"));
        System.out.println("[LibTest] My pid = " + Lib.getMyPid());
        System.out.println("[LibTest] My pid old = " + Lib.getMyPidOld());
        System.out.println("[LibTest] My pid new = " + Lib.getMyPidNew());
    }

}
