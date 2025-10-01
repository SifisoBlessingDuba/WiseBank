package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.User;

import java.util.List;

public interface IUserService extends IService <User, String> {
    List<User> findAll();

}
