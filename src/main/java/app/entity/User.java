package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.UUID;

/**
 * Classe que representa a tabela USER
 *
 * @generated
 */
@Entity
@Table(name = "USER")
@XmlRootElement
public class User implements Serializable {

    /**
     * UID da classe, necessário na serialização
     *
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @generated
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id = UUID.randomUUID().toString().toUpperCase();

    /**
     * @generated
     */
    @Column(name = "email")
    private String email;

    /**
     * @generated
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * @generated
     */
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    /**
     * @generated
     */
    @Column(name = "picture")
    private byte[] picture;

    /**
     * @generated
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Construtor
     *
     * @generated
     */
    public User() {
    }


    /**
     * Obtém email
     * return email
     *
     * @generated
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Define email
     *
     * @param email email
     * @generated
     */
    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Obtém name
     * return name
     *
     * @generated
     */
    public String getName() {
        return this.name;
    }

    /**
     * Define name
     *
     * @param name name
     * @generated
     */
    public User setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Obtém id
     * return id
     *
     * @generated
     */
    public String getId() {
        return this.id;
    }

    /**
     * Define id
     *
     * @param id id
     * @generated
     */
    public User setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Obtém login
     * return login
     *
     * @generated
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Define login
     *
     * @param login login
     * @generated
     */
    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    /**
     * Obtém picture
     * return picture
     *
     * @generated
     */
    public byte[] getPicture() {
        return this.picture;
    }

    /**
     * Define picture
     *
     * @param picture picture
     * @generated
     */
    public User setPicture(byte[] picture) {
        this.picture = picture;
        return this;
    }

    /**
     * Obtém password
     * return password
     *
     * @generated
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Define password
     *
     * @param password password
     * @generated
     */
    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * @generated
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User object = (User) obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
     * @generated
     */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}