package org.antholoj.bndlibtest;

import aQute.bnd.build.Project;
import aQute.bnd.build.model.BndEditModel;
import aQute.bnd.build.model.clauses.ExportedPackage;
import aQute.bnd.osgi.Analyzer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Project proj;
        BndEditModel model;
        model = new BndEditModel();
        InputStream bnd = App.class.getResourceAsStream("bnd.bnd");
        model.loadFrom(bnd);
        
        
        String bundleActivator = model.getBundleActivator();
        System.out.println("Bundle Acticator: " + bundleActivator);
        
        List<ExportedPackage> exportedPackages = model.getExportedPackages();
        System.out.println("Exported Packages:");
        for (ExportedPackage exportedPackage : exportedPackages) {
            System.out.println("\t" + exportedPackage.getName());
        }
        
        System.out.println("Private Packages:");
        List<String> privatePackages = model.getPrivatePackages();
        for (String privatePackage : privatePackages) {
            System.out.println("\t" + privatePackage);
        }
        
    }
}
