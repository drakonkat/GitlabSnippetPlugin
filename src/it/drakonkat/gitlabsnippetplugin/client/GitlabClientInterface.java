/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.client;

import it.drakonkat.gitlabsnippetplugin.client.model.GitlabModel;
import java.util.List;

/**
 *
 * @author mmazzocchetti
 */
public interface GitlabClientInterface {

        GitlabModel getSnippet(String id) throws Exception;

        Boolean saveSnippet(GitlabModel gitlabModel) throws Exception;

        Boolean deleteSnippet(String id) throws Exception;

        List<GitlabModel> getSnippets() throws Exception;
}
