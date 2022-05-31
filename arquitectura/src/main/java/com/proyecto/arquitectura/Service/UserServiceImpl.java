package com.proyecto.arquitectura.Service;

import java.util.Optional;

import com.proyecto.arquitectura.dao.UserDao;
import com.proyecto.arquitectura.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
    
    @Autowired
    private UserDao userDao;

    @Override
    public Iterable<User> findAll(){
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(Long Id){
        return userDao.findById(Id);
    }

    @Override
    public User save(User user){
        return userDao.save(user);
    }

    @Override
    public void delete(Long Id){
        userDao.deleteById(Id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsuario(username);

        if(null == user){
            throw new UsernameNotFoundException("Usuario no encontrado" + username);
        }
        return user;
    }

    
}
