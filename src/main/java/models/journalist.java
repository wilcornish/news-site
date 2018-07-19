package models;

@Entity
@Table(name = "journalists")
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

    public journalist(){}

    @Id
    @GenerateValue
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="bio")
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    @Column(name="twitter")
    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Column(name="pictures")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Column(name="articles")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
