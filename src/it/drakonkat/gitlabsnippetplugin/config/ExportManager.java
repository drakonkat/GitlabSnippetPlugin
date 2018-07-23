/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.drakonkat.gitlabsnippetplugin.client.model.GitlabModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mmazzocchetti
 */
public class ExportManager {

        private static final String DEFAULT_PATH = "snippet.json";

        private static ExportManager instance = null;

        public static ExportManager getInstance() {
                if (instance == null) {
                        instance = new ExportManager();
                }
                return instance;

        }

        public void exportSnippet(List<GitlabModel> list) throws IOException {
                exportSnippet(list, DEFAULT_PATH);
        }

        public void exportSnippet(List<GitlabModel> list, String path) throws IOException {
                try (FileWriter out = new FileWriter(path)) {
                        Gson gson = new Gson();
                        String output = gson.toJson(list);
                        out.write(output);
                }
        }

        public List<GitlabModel> importSnippet() throws FileNotFoundException, IOException {
                return importSnippet(DEFAULT_PATH);
        }

        public List<GitlabModel> importSnippet(String path) throws FileNotFoundException, IOException {
                try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                        Gson gson = new Gson();
                        Type listType = new TypeToken<ArrayList<GitlabModel>>() {
                        }.getType();
                        return gson.fromJson(br, listType);
                }
        }
}
