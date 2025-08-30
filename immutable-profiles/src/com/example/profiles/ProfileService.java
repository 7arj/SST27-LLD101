package com.example.profiles;

public class ProfileService {

    //create minimal profile using builder pattern
    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    // Returns new profile instead of mutating existing one

    public UserProfile updateDisplayName(UserProfile originalProfile, String displayName) {
        if (originalProfile == null) {
            throw new IllegalArgumentException("profile cannot be null");
        }
        
        //Apply same trimming logic but return new profile
        String finalDisplayName = displayName;
        if (displayName != null && displayName.length() > 100) {
            finalDisplayName = displayName.substring(0, 100);
        }
        
        // create new profile with all existing values plus updated display name

        return new UserProfile.Builder(originalProfile.getId(), originalProfile.getEmail())
                .setPhone(originalProfile.getPhone())
                .setDisplayName(finalDisplayName)
                .setAddress(originalProfile.getAddress())
                .setMarketingOptIn(originalProfile.isMarketingOptIn())
                .setTwitter(originalProfile.getTwitter())
                .setGithub(originalProfile.getGithub())
                .build();
    }
}