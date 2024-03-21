package com.example.esunbank.Service.Impl;



import com.example.esunbank.Dao.Impl.UserDaoImpl;
import com.example.esunbank.Model.User;
import com.example.esunbank.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl userDao;

    public String registerUser(User user) {
        String registerUser = userDao.addUser(user);
        return registerUser;
    }

    public String loginUser(String phone, String password) {
        User user = userDao.findByPhone(phone);
        if (user != null){
            if (user.getPassword().equals(password)){
                return "Success";
            }else {
                return "False";
            }
        }else{
            return "False";
        }
    }


}
