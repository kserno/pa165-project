package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Entity representing user of the system
 *
 * @author Filip Sollar
 */
@Entity
@Table(name = "web_user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String username;

    @NotNull
    private String passwordHash;

    private boolean isAdmin;

    @Lob
    private byte[] image;

    private String imageMimeType;

    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Effectiveness> posts = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<Effectiveness> getPosts() {
        return posts;
    }

    public void setPosts(List<Effectiveness> posts) {
        this.posts = posts;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageMimeType() {
        return imageMimeType;
    }

    public void setImageMimeType(String imageMimeType) {
        this.imageMimeType = imageMimeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isAdmin == user.isAdmin &&
                Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(passwordHash, user.passwordHash) &&
                Arrays.equals(image, user.image) &&
                Objects.equals(imageMimeType, user.imageMimeType) &&
                Objects.equals(posts, user.posts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, email, name, username, passwordHash, isAdmin, imageMimeType, posts);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
