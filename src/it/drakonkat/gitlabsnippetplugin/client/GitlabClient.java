package it.drakonkat.gitlabsnippetplugin.client;

import it.drakonkat.gitlabsnipperplugin.config.PropertiesManager;
import it.drakonkat.gitlabsnippetplugin.client.model.GitlabModel;
import java.io.FileNotFoundException;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mmazzocchetti
 */
public class GitlabClient implements GitlabClientInterface {

        public GitlabClient() {
        }

        @Override
        public GitlabModel getSnippet(String id) throws Exception {
                try {
                        Properties p = PropertiesManager.getInstance().loadProperties();
                        String url = p.getProperty("url");
                        Client client = ClientBuilder.newClient();
                        WebTarget webTarget = client.target(url);
                        Response response = webTarget.path("/snippets/" + id).request(MediaType.APPLICATION_JSON_TYPE).header("Private-Token", p.getProperty("token")).get();
                        if (!(response.getStatus() == 200)) {
                                throw new Exception("Response errata " + response.getStatus());
                        }
                        GitlabModel model = response.readEntity(new GenericType<GitlabModel>() {
                        });
                        return model;
                } catch (FileNotFoundException ex) {
                        Logger.getLogger(GitlabClient.class.getName()).log(Level.SEVERE, "Errore nell'instanziare il file di properties", ex);
                        throw ex;
                } catch (Exception ex) {
                        Logger.getLogger(GitlabClient.class.getName()).log(Level.SEVERE, "Eccezione generica", ex);
                        throw ex;
                }
        }

        @Override
        public Boolean saveSnippet(GitlabModel gitlabModel) throws Exception {
                try {
                        Properties p = PropertiesManager.getInstance().loadProperties();
                        String url = p.getProperty("url");
                        Client client = ClientBuilder.newClient();
                        WebTarget webTarget = client.target(url);
                        Response response = null;
                        if (getSnippet(gitlabModel.getId()) != null) {
                                response = webTarget.path("/snippets/" + gitlabModel.getId()).request(MediaType.APPLICATION_JSON_TYPE).header("Private-Token", p.getProperty("token")).post(Entity.entity(gitlabModel, MediaType.APPLICATION_JSON));
                        } else {
                                response = webTarget.path("/snippets").request(MediaType.APPLICATION_JSON_TYPE).header("Private-Token", p.getProperty("token")).post(Entity.entity(gitlabModel, MediaType.APPLICATION_JSON));
                        }
                        if (!(response.getStatus() == 200)) {
                                throw new Exception("Response errata " + response.getStatus());
                        }

                        return true;
                } catch (FileNotFoundException ex) {
                        Logger.getLogger(GitlabClient.class.getName()).log(Level.SEVERE, "Errore nell'instanziare il file di properties", ex);
                        throw ex;
                } catch (Exception ex) {
                        Logger.getLogger(GitlabClient.class.getName()).log(Level.SEVERE, "Eccezione generica", ex);
                        throw ex;
                }
        }

        @Override
        public Boolean deleteSnippet(String id) throws Exception {
                try {
                        Properties p = PropertiesManager.getInstance().loadProperties();
                        String url = p.getProperty("url");
                        Client client = ClientBuilder.newClient();
                        WebTarget webTarget = client.target(url);
                        Response response = webTarget.path("/snippets/" + id).request(MediaType.APPLICATION_JSON_TYPE).header("Private-Token", p.getProperty("token")).delete();
                        if (!(response.getStatus() == 200)) {
                                throw new Exception("Response errata " + response.getStatus());
                        }
                        return true;
                } catch (FileNotFoundException ex) {
                        Logger.getLogger(GitlabClient.class.getName()).log(Level.SEVERE, "Errore nell'instanziare il file di properties", ex);
                        throw ex;
                } catch (Exception ex) {
                        Logger.getLogger(GitlabClient.class.getName()).log(Level.SEVERE, "Eccezione generica", ex);
                        throw ex;
                }
        }

        @Override
        public List<GitlabModel> getSnippets() throws Exception {
                try {
                        Properties p = PropertiesManager.getInstance().loadProperties();
                        String url = p.getProperty("url");
                        Client client = ClientBuilder.newClient();
                        WebTarget webTarget = client.target(url);
                        Response response = webTarget.path("/snippets").request(MediaType.APPLICATION_JSON_TYPE).header("Private-Token", p.getProperty("token")).get();
                        if (!(response.getStatus() == 200)) {
                                throw new Exception("Response errata " + response.getStatus());
                        }
                        List<GitlabModel> model = response.readEntity(new GenericType<List<GitlabModel>>() {
                        });
                        return model;
                } catch (FileNotFoundException ex) {
                        Logger.getLogger(GitlabClient.class.getName()).log(Level.SEVERE, "Errore nell'instanziare il file di properties", ex);
                        throw ex;
                } catch (Exception ex) {
                        Logger.getLogger(GitlabClient.class.getName()).log(Level.SEVERE, "Eccezione generica", ex);
                        throw ex;
                }
        }

}
