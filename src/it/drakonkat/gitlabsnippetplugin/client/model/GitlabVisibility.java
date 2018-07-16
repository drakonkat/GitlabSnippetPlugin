/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.client.model;

/**
 *
 * @author mmazzocchetti
 */
public enum GitlabVisibility {
        PRIVATE("private"), ITNERNAL("internal"), PUBLIC("public");

        private final String visibility;

        private GitlabVisibility(String visibility) {
                this.visibility = visibility;
        }

}
