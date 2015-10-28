package org.meriloo.customers.service;

/**
 * Created by Lauri on 28.10.2015.
 */
public interface PasswordService {

    public String getSaltedHash(String password) throws Exception;

    public boolean check(String password, String stored) throws Exception;
}
