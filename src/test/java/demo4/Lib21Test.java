package demo4;

import org.junit.jupiter.api.Test;

// #excludeif target.java.version < mrjar.newestVersion
public class Lib21Test {

    @Test
    public void testJavaVersions() {
        System.out.println("[LibTest21] Current Java version: " + System.getProperty("java.runtime.version"));
        System.out.println("[LibTest21] Compiled for version: /*$target.java.version$*/");
    }

    @Test
    public void testGetMyPids() {
        System.out.println("[LibTest21] Java version = " + System.getProperty("java.runtime.version"));
        System.out.println("[LibTest21] Java classpath = " + System.getProperty("java.class.path"));
        System.out.println("[LibTest21] My pid = " + Lib.getMyPid());
        System.out.println("[LibTest21] My pid old = " + Lib.getMyPidOld());
        System.out.println("[LibTest21] My pid new = " + Lib.getMyPidNew());
    }

}
