
package DAL;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import model.Account;


public class Validate {
    public String getMd5(String input)
    {
        try {
 
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String checkAccountSetting(Account account, String username, String password, String newpassword, String renewpassword, String questionId, String answer) {
        String mess = "";
        DAO dao = new DAO();
        if(!getMd5(password).equals(account.getPassword())){
            mess = "password is incorrect";           
        }else if(!newpassword.equals(renewpassword)){
            mess = "new password must be equal re-newpassword";  
        }else if(!questionId.equals(account.getQuestionId())){
            mess = "questionId is incorrect";
        }else if(!answer.equals(account.getAnswer())){
            mess = "answer is incorrect";
        }else{
            mess = "change successfully";
            dao.updatePassword(getMd5(newpassword), username);
        }
        return mess;
    }

    public String checkSignUp(String username, String password, String repassword, String fullname,boolean isAdmin, String email, String phone, String questionId, String cityId, String answer) {
        DAO dao = new DAO();
        String mess = "";
        if(dao.checkAccountExist(username)){
            mess = "username is already exist.";           
        }else if(!password.equals(repassword)){
            mess = "password is not match re-password.";
        }else{
            dao.insertAccount(username, getMd5(password), fullname, isAdmin, email, phone, questionId, cityId, answer);
            mess = "sign up successfully.";       
        }
        return mess;
    }

    public String checkForgetAccount(Account account, String questionId, String answer, String newpassword, String renewpassword) {
        String mess = "";
        DAO dao = new DAO();
        if(account==null)
            mess = "username is incorrect";
        else if(!questionId.equals(account.getQuestionId()))
            mess = "question is incorrect";
        else if(!answer.equals(account.getAnswer()))
            mess = "answer is incorrect";
        else if(!newpassword.equals(renewpassword))
            mess = "new password must be equal re-new password";
        else{
            mess = "successfully";
            dao.updatePassword(getMd5(newpassword), account.getUsername());
        }
        return mess;
    }
    
    
}
