package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.User;

import java.util.List;

public interface IUserService extends IService <User, String> {
    List<User> findAll();

}
//guys check if this page will show up in the final project
//66
