package models;

@Entity
public class journalist {
    private int id;
    private String name;
    private String bio;
    private String twitter;
    private String picture;
    private List<Article> articles;


    public journalist(String name, String bio, String twitter, String picture) {
        this.name = name;
        this.bio = bio;
        this.twitter = twitter;
        this.picture = picture;
        this.articles = new List<Article>;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
