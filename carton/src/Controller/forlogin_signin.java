
package Controller;


import databaseconnection.DataBaseConnection;
import  model.ModelUserData;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class forlogin_signin {
        
        public forlogin_signin(){
        
            try {
                DataBaseConnection.getInstance().ConnectToDatabase();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        public boolean addUserDatabase(ModelUserData data) {
            try {
                String sql = "INSERT INTO usersdata(username,password) values(?,?)";
                    PreparedStatement p = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);
                        p.setString(1, data.getGetUsername());
                        p.setString(2, new String(data.getGetPassword()));
                p.executeUpdate();
                    return true;
            } catch (Exception e) {
                e.printStackTrace();
                     return false;
            }
        }
        
        public ModelUserData login (ModelUserData data){
            try {
                String sql = "SELECT * FROM usersdata WHERE username LIKE ? AND password LIKE ?";
                    PreparedStatement p = DataBaseConnection.getInstance().getConnection().prepareCall(sql);
                        p.setString(1, data.getGetUsername());
                        p.setString(2, new String(data.getGetPassword()));
                ResultSet rs = p.executeQuery();
                if (rs.next()) {
                    return new ModelUserData( rs.getString("username"), rs.getString("password").toCharArray());
                } else {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                    return null;
            }
        
        }
        
        public String Encryp (String password){
            try {
                MessageDigest digester = MessageDigest.getInstance("SHA-256");
                byte [] encodeHash = digester.digest(password.getBytes(StandardCharsets.UTF_8));
                StringBuilder encryptionValue = new StringBuilder(2 * encodeHash.length);
                for (int i = 0; i < encodeHash.length; i++) {
                    String hVal = Integer.toHexString(0xff & encodeHash[i]);
                    if (hVal.length() == 1) {
                        encryptionValue.append('0'); 
                    }
                    encryptionValue.append(hVal);
                }
                return encryptionValue.toString();
            } catch (Exception e) {
                return e.getMessage();
            }
        
        }
}


