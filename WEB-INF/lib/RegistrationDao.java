package student;

import com.adventnet.authentication.*;
import com.adventnet.authentication.util.AuthUtil;
import com.adventnet.persistence.DataAccessException;
import com.adventnet.persistence.DataObject;
import com.adventnet.persistence.Row;
import com.adventnet.mfw.bean.BeanUtil;
import com.adventnet.persistence.Persistence;


public class RegistrationDao{

    void register(String name, String email, String password, String role){
        System.out.println("Inside Login Function");
        String serviceName = "System";
        String accAdminProfile = "Profile 1";
        String passwordProfile = "Profile 1";
        try
        {
            Persistence persistence = (Persistence) BeanUtil.lookup("Persistence"); 
            DataObject dobj = persistence.constructDataObject();
            Row userRow = new Row(AAAUSER.TABLE);
            userRow.set(AAAUSER.FIRST_NAME, name);
            // userRow.set(AAAUSER.MIDDLE_NAME, middleName); // optional
            // userRow.set(AAAUSER.LAST_NAME, lastName); // optional
            dobj.addRow(userRow);

            Row loginRow = new Row(AAALOGIN.TABLE);
            loginRow.set(AAALOGIN.NAME, email);
            dobj.addRow(loginRow);

            Row accRow = new Row(AAAACCOUNT.TABLE);
            accRow.set(AAAACCOUNT.SERVICE_ID, AuthUtil.getServiceId(serviceName));
            accRow.set(AAAACCOUNT.ACCOUNTPROFILE_ID, AuthUtil.getAccountProfileId(accAdminProfile));
            dobj.addRow(accRow);

            Row passwordRow = new Row(AAAPASSWORD.TABLE);
            passwordRow.set(AAAPASSWORD.PASSWORD, password);
            passwordRow.set(AAAPASSWORD.PASSWDPROFILE_ID, AuthUtil.getPasswordProfileId(passwordProfile));
            dobj.addRow(passwordRow);

            Row accPassRow = new Row(AAAACCPASSWORD.TABLE);
            accPassRow.set(AAAACCPASSWORD.ACCOUNT_ID, accRow.get(AAAACCOUNT.ACCOUNT_ID));
            accPassRow.set(AAAACCPASSWORD.PASSWORD_ID, passwordRow.get(AAAPASSWORD.PASSWORD_ID));
            dobj.addRow(accPassRow);

            // to assign roles - optional
            Row authRoleRow1 = new Row(AAAAUTHORIZEDROLE.TABLE);
            authRoleRow1.set(AAAAUTHORIZEDROLE.ACCOUNT_ID, accRow.get(AAAACCOUNT.ACCOUNT_ID));
            authRoleRow1.set(AAAAUTHORIZEDROLE.ROLE_ID, AuthUtil.getRoleId(role));
            dobj.addRow(authRoleRow1);


            // to permit this user to create another user - optional
            int noOfSubAccounts = -1; // -1 to create unlimited users, 0 - for no user, n - to create n user accounts
            Row accOwnerProfileRow = new Row(AAAACCOWNERPROFILE.TABLE);
            accOwnerProfileRow.set(AAAACCOWNERPROFILE.ACCOUNT_ID, accRow.get(AAAACCOUNT.ACCOUNT_ID));
            accOwnerProfileRow.set(AAAACCOWNERPROFILE.ALLOWED_SUBACCOUNT, noOfSubAccounts);
            dobj.addRow(accOwnerProfileRow);

            AuthUtil.createUserAccount(dobj);

            System.out.println("Successfully added: "+name+" as: "+role);
        }
        catch(PasswordException pe)
        {
            pe.printStackTrace();
        }
        catch(DataAccessException dae)
        {
            dae.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}