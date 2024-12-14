package com.example.users.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.users.dto.UserRequestDto;
import com.example.users.model.User;
import com.example.users.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(UserRequestDto userRequestDto) {
        Optional<User> existingUserByCedula = userRepository.findByCedula(userRequestDto.getCedula());
        if (existingUserByCedula.isPresent()) {
            return "La cédula ya está registrada.";
        }

        Optional<User> existingUserByCorreo = userRepository.findByCorreo(userRequestDto.getCorreo());
        if (existingUserByCorreo.isPresent()) {
            return "El correo ya está registrado.";
        }

        User newUser = new User();
        newUser.setCedula(userRequestDto.getCedula());
        newUser.setNombre(userRequestDto.getNombre());
        newUser.setApellido(userRequestDto.getApellido());
        newUser.setCorreo(userRequestDto.getCorreo());
        newUser.setPassword(userRequestDto.getPassword());
        newUser.setCelular(userRequestDto.getCelular());
        newUser.setFechaNacimiento(userRequestDto.getFechaNacimiento());
        userRepository.save(newUser);
        return "Usuario registrado exitosamente.";
    }
    public String authenticateUser(String correo, String password) {
        Optional<User> existingUserByCorreo = userRepository.findByCorreo(correo);
        if (existingUserByCorreo.isPresent()) {
            User user = existingUserByCorreo.get();

            // Comparar las contraseñas directamente
            if (password.equals(user.getPassword())) {
                return "Autenticación exitosa";
            } else {
                return "Contraseña incorrecta";
            }
        } else {
            return "Usuario no encontrado";
        }
    }
  }
