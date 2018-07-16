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
class GitlabUser {

        @Override
        public String toString() {
                return "GitlabUser{" + "id=" + id + ", username=" + username + ", email=" + email + ", name=" + name + ", state=" + state + ", created_at=" + created_at + '}';
        }

        private String id;
        private String username;
        private String email;
        private String name;
        private String state;
        private String created_at;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public String getCreated_at() {
                return created_at;
        }

        public void setCreated_at(String created_at) {
                this.created_at = created_at;
        }

}
