package demo4;

import java.lang.management.ManagementFactory;

// supports Java 8 and 9+
public class Lib {

    // if you want have only one active piece of code, you can use '//$' which tells
    // to preprocessor to uncoment marked string in preprocessing
    // and here I have both variants uncommented

    public static long getMyPid() {
        System.out.println("[Lib] (getMyPid called, compiled for version /*$target.java.version$*/)");
        // #if target.java.version >= 9
        System.out.println("java.version >= 9");
        return getMyPidNew();
        // #else
        // $System.out.println("java.version < 9");
        // $return getMyPidOld();
        // #endif
    }

    public static long getMyPidOld() {
        System.out.println("[Lib] getMyPidOld called)");
        final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        final int index = jvmName.indexOf('@');
        return Long.parseLong(jvmName.substring(0, index));
    }

    public static long getMyPidNew() {
        System.out.println("[Lib] getMyPidNew called)");
        // #if target.java.version >= 9
        return ProcessHandle.current().pid();
        // #else
        // $return -1;
        // #endif
    }

}
