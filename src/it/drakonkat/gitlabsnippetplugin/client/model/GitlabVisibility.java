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
        PRIVATE(0), ITNERNAL(10), PUBLIC(20);

        private final Integer visibility;

        private GitlabVisibility(Integer visibility) {
                this.visibility = visibility;
        }

        public Integer getVisibility() {
                return visibility;
        }

}
