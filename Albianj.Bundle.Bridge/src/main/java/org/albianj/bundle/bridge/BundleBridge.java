package org.albianj.bundle.bridge;

import org.albianj.framework.boot.ApplicationContext;
import org.albianj.framework.boot.BundleContext;
import org.albianj.framework.boot.IBundleListener;
import org.albianj.framework.boot.except.ThrowableServant;

public class BundleBridge {
    public static void newBundle(String[] args) {
        try {
            ApplicationContext.Instance
                    .addBundle(BundleBridge.class, BundleContext.newInstance().setArgs(args)
                            .setStartupClassName("Albianj.ChildBundle.BusinessBundle")
                            .setInstallSpxFile(false)
                            .setBinFolder("D:\\work\\github\\albianj2\\Albianj.ChildBundle\\target",false)
                            .setConfFolder("D:\\work\\github\\albianj2\\Albianj.ChildBundle\\src\\main\\resources\\config")
                            .setLibFolder("D:\\work\\github\\albianj2\\Albianj.ChildBundle\\target\\lib",true)
                            .setWorkFolder("D:\\work\\github\\albianj2\\Albianj.ChildBundle")
                            .setBundleName("ChildBundle")
                            .setBeginStartupEvent(new IBundleListener() {
                                @Override
                                public void onActionExecute(BundleContext bctx) {
                                    System.out.println("Start ChildBundle -> " + bctx.getBundleName());
                                }})
                            .build());
        } catch (Exception e) {
            System.out.println("Exception Stacks -> " + ThrowableServant.Instance.printThrowStackTrace(e));
        }
    }
}
