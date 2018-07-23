/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.client.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author mmazzocchetti
 */
public class GitlabModel implements Serializable {

        private GitlabVisibility visibility;
        private String content;
        private String id;
        private String title;
        private String file_name;
        private String description;
        private String updated_at;
        private String created_at;
        private String web_url;
        private GitlabUser author;

        public GitlabVisibility getVisibility() {
                return visibility;
        }

        public void setVisibility(GitlabVisibility visibility) {
                this.visibility = visibility;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getFile_name() {
                return file_name;
        }

        public void setFile_name(String file_name) {
                this.file_name = file_name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getUpdated_at() {
                return updated_at;
        }

        public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
        }

        public String getCreated_at() {
                return created_at;
        }

        public void setCreated_at(String created_at) {
                this.created_at = created_at;
        }

        public String getWeb_url() {
                return web_url;
        }

        public void setWeb_url(String web_url) {
                this.web_url = web_url;
        }

        public GitlabUser getAuthor() {
                return author;
        }

        public void setAuthor(GitlabUser author) {
                this.author = author;
        }

        @Override
        public String toString() {
                return "GitlabModel{" + "visibility=" + visibility + ", content=" + content + ", id=" + id + ", title=" + title + ", file_name=" + file_name + ", description=" + description + ", updated_at=" + updated_at + ", created_at=" + created_at + ", web_url=" + web_url + ", author=" + author + '}';
        }

        @Override
        public int hashCode() {
                int hash = 5;
                hash = 67 * hash + Objects.hashCode(this.id);
                return hash;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj) {
                        return true;
                }
                if (obj == null) {
                        return false;
                }
                if (getClass() != obj.getClass()) {
                        return false;
                }
                final GitlabModel other = (GitlabModel) obj;
                if (!Objects.equals(this.id, other.id)) {
                        return false;
                }
                return true;
        }

}
