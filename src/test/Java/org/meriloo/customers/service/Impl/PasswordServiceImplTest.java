package org.meriloo.customers.service.Impl;

import junit.framework.TestCase;
import org.meriloo.customers.service.PasswordService;

/**
 * Created by Lauri on 28.10.2015.
 */
public class PasswordServiceImplTest extends TestCase {


    public void testCheck() throws Exception {
        PasswordService passwordService = new PasswordServiceImpl();
        String password1 = "Password1";
        String password2 = "Password2";
        String password1Hashed = passwordService.getSaltedHash(password1);
        assertEquals(true,passwordService.check(password1,password1Hashed));
        assertEquals(false,passwordService.check(password2,password1Hashed));

    }
}