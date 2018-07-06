/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.frame;

import it.drakonkat.gitlabsnipperplugin.config.PropertiesManager;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 *
 * @author mmazzocchetti
 */
public class GitlabSnippetPlugin {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                try {
                        // TODO code application logic here
                        Properties properties = PropertiesManager.getInstance().loadProperties();
                        System.out.println("ok" + properties.getProperty("username"));
                } catch (FileNotFoundException ex) {
                        System.out.println("errore " + ex.getMessage());
                        ex.printStackTrace();
                }
        }
        
}
