package com.akshay.marketplaceApi.services;

import com.akshay.marketplaceApi.payloads.ProductDto;
import com.akshay.marketplaceApi.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(int userId);
    UserDto updateUser(UserDto userDto, int userId);
    void deleteUser(int UserId);
}
