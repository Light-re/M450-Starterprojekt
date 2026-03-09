public class UserRegistration {
    private String email;
    private String password;
    private String profilePictureUrl;
    private String biography;
    private String favoriteColor;

    public UserRegistration(String email, String password, String profilePictureUrl, String biography, String favoriteColor) {
        this.email = email;
        this.password = password;
        this.profilePictureUrl = profilePictureUrl;
        this.biography = biography;
        this.favoriteColor = favoriteColor;
    }
}

/*
USER STORY:
"As admin, I want to register users with email and password so they can log in."

TASKS:
1) Explain what violates YAGNI.
2) Rewrite the class so it only contains required data.
3) Add one sentence: when should extra fields be added?
*/
