/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author mmazzocchetti
 */
public class PropertiesManager {

        private static final String DEFAULT_PATH = "config.properties";

        private static PropertiesManager instance = null;

        public static PropertiesManager getInstance() {
                if (instance == null) {
                        instance = new PropertiesManager();
                }
                return instance;

        }

        public Properties loadProperties() throws FileNotFoundException {
                return loadProperties(DEFAULT_PATH, true);
        }

        public void modifyProperties(Properties properties) throws FileNotFoundException {
                modifyProperties(properties, DEFAULT_PATH);
        }

        /**
         * Genera delle properties da un file
         *
         * @param path Path del file da cui recuperare le properties
         * @param inner Definisce se il file è una resource dell'applicativo
         * oppure no
         * @return Properties recuperato dal file
         * @throws FileNotFoundException
         */
        public Properties loadProperties(String path, Boolean inner) throws FileNotFoundException {
                InputStream is = null;
                Properties element = new Properties();
                // Controllo se interno all'applicativo
                if (inner) {
                        //Lo carico dalle risorse
                        is = Thread.currentThread().getContextClassLoader().getResourceAsStream(DEFAULT_PATH);
                } else {
                        //Lo carico come risorsa esterna
                        try {
                                is = new FileInputStream(path);
                        } catch (FileNotFoundException e) {
                        }
                }
                if (is == null) {
                        //Se non lo trovo lancio un eccezione
                        throw new FileNotFoundException("File not found: " + path);
                }

                // Crea un nuovo Porperties
                element = new Properties();
                try {
                        // Carica il file di properties
                        element.load(is);
                } catch (Exception e) {
                        throw new FileNotFoundException(e.getMessage());
                } finally {
                        try {
                                is.close();
                        } catch (IOException e) {
                        }
                }
                return element;
        }

        public void modifyProperties(Properties properties, String path) {
                try {
                        File f = new File(path);
                        OutputStream out = new FileOutputStream(f);
                        properties.store(out, "Aggiornamento properties " + System.currentTimeMillis());
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
