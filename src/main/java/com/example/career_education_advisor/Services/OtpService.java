package com.example.career_education_advisor.Services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class OtpService {

    // email -> OTP
    private final Map<String, String> otpStore = new HashMap<>();

    // email -> OTP expiry time
    private final Map<String, LocalDateTime> otpExpiry = new HashMap<>();

    // Verified emails
    private final Map<String, Boolean> verifiedEmails = new HashMap<>();

    // ================= GENERATE OTP =================

    public String generateOtp() {

        return String.valueOf(
                (int) (Math.random() * 900000) + 100000);
    }

    // ================= SAVE OTP =================

    public void saveOtp(String email, String otp) {

        otpStore.put(email, otp);

        // OTP valid for 5 minutes
        otpExpiry.put(
                email,
                LocalDateTime.now().plusMinutes(5));

        // New OTP means previous verification is no longer valid
        verifiedEmails.put(email, false);
    }

    // ================= VERIFY OTP =================

    public boolean verifyOtp(String email, String otp) {

        String storedOtp = otpStore.get(email);

        LocalDateTime expiryTime = otpExpiry.get(email);

        // OTP not found
        if (storedOtp == null || expiryTime == null) {
            return false;
        }

        // OTP expired
        if (LocalDateTime.now().isAfter(expiryTime)) {

            otpStore.remove(email);
            otpExpiry.remove(email);

            return false;
        }

        // OTP incorrect
        if (!storedOtp.equals(otp)) {
            return false;
        }

        // OTP correct
        otpStore.remove(email);
        otpExpiry.remove(email);

        verifiedEmails.put(email, true);

        return true;
    }

    // ================= CHECK EMAIL VERIFIED =================

    public boolean isEmailVerified(String email) {

        return Boolean.TRUE.equals(
                verifiedEmails.get(email));
    }

    // ================= REMOVE VERIFIED EMAIL =================

    public void removeVerifiedEmail(String email) {

        verifiedEmails.remove(email);
    }
}