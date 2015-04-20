package any;

import java.security.MessageDigest;

public class Keys {

    public static String createApplicationKey(String accountId, String salt) {
        String hash = "";
        if (accountId == null || salt == null)
            return hash;
        for (int i = 0; i < 1000; i++) {
            hash = sha256(hash + salt + accountId);
        }
        return hash;
    }

    private static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
    }
}
