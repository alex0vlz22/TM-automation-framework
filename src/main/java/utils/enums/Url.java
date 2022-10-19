package utils.enums;

public enum Url {

    ORANGE_DEMO("Orange", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    private String name;
    private String url;

    Url(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
