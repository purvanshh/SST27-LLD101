package com.example.profiles;

import java.util.Objects;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    // returns a fully built immutable profile
    public UserProfile createMinimal(String id, String email) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("bad id");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("bad email");
        return new UserProfile(id, email);
    }

    // returns a new profile with updated displayName (immutability)
    public UserProfile withDisplayName(UserProfile p, String displayName) {
        Objects.requireNonNull(p, "profile");
        if (displayName != null && displayName.length() > 100) {
            displayName = displayName.substring(0, 100);
        }
        return new UserProfile(
            p.getId(),
            p.getEmail(),
            p.getPhone(),
            displayName,
            p.getAddress(),
            p.isMarketingOptIn(),
            p.getTwitter(),
            p.getGithub()
        );
    }
}
