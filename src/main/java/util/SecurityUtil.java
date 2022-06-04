package util;

import com.example.shop_clone.configuration.CustomUserDetail;
import com.example.shop_clone.exception.BadRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static Integer getUserId() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();
            return userDetails.getId();
        } catch (Exception e) {
            throw new BadRequest("Error");
        }
    }

    public static String getUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
