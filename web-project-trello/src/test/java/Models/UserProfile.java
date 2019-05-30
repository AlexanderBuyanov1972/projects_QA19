package Models;

import java.io.File;

public class UserProfile {
    String fullName;
    String userName;
    String initials;
    String bio;
    File foto;

    public UserProfile(){}

    public String getFullName() {
        return fullName;
    }

    public UserProfile withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserProfile withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getInitials() {
        return initials;
    }

    public UserProfile withInitials(String initials) {
        this.initials = initials;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public UserProfile withBio(String bio) {
        this.bio = bio;
        return this;
    }

    public File getFoto() {
        return foto;
    }

    public UserProfile withFoto(File foto) {
        this.foto = foto;
        return this;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", initials='" + initials + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
