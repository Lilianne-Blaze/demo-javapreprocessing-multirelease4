package demo4;

public class App {

    public static void main(String[] args) {
        System.out.println("Current Java version: " + System.getProperty("java.runtime.version"));
        System.out.println("Compiled for version: /*$target.java.version$*/");

        System.out.println("My pid = " + Lib.getMyPid());
        System.out.println("My pid old = " + Lib.getMyPidOld());
        System.out.println("My pid new = " + Lib.getMyPidNew());
    }

}
