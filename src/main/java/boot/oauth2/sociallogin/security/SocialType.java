package boot.oauth2.sociallogin.security;

public enum SocialType {
    GOOGLE("google"),
    GITHUB("github"),
    FACEBOOK("facebook");

    private final String ROLE_PREFIX = "ROLE_";
    private String name;

    SocialType(String name) {this.name = name;}

    public String getRoleType() { return ROLE_PREFIX + name.toUpperCase(); }

    public String getValue() { return name; }

    public boolean isEquals(String authority) { return this.getRoleType().equals(authority); }
}
