package com.example.profiles;

public class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    // Private constructor - only Builder can create instances

    private UserProfile(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.phone = builder.phone;
        this.displayName = builder.displayName;
        this.address = builder.address;
        this.marketingOptIn = builder.marketingOptIn;
        this.twitter = builder.twitter;
        this.github = builder.github;
    }

    // only getters - no setters for immutability
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }

   
    public static class Builder {
        //required fields
        private final String id;
        private final String email;
        
        // Optional fields with defaults
        private String phone = null;
        private String displayName = null;
        private String address = null;
        private boolean marketingOptIn = false;
        private String twitter = null;
        private String github = null;

        // constructor requires mandatory fields
        public Builder(String id, String email) {
            this.id = id;
            this.email = email;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setMarketingOptIn(boolean marketingOptIn) {
            this.marketingOptIn = marketingOptIn;
            return this;
        }

        public Builder setTwitter(String twitter) {
            this.twitter = twitter;
            return this;
        }

        public Builder setGithub(String github) {
            this.github = github;
            return this;
        }

        //centralized validation in build method
        public UserProfile build() {
            // Validate required fields
            Validation.requireNonBlank(id, "User ID");
            Validation.requireEmail(email);
            
            // Validate optional fields

            if (displayName != null && displayName.length() > 100) {
                throw new IllegalArgumentException("Display name cannot exceed 100 characters");
            }
            
            if (phone != null && Validation.isBlank(phone)) {
                throw new IllegalArgumentException("Phone cannot be blank if provided");
            }
            
            //basic validation for social handles
            if (twitter != null && twitter.length() > 50) {
                throw new IllegalArgumentException("Twitter handle too long");
            }
            
            if (github != null && github.length() > 50) {
                throw new IllegalArgumentException("GitHub handle too long");
            }

            return new UserProfile(this);
        }
    }
}
