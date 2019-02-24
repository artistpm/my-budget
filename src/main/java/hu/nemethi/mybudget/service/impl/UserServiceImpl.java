package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.entity.User;
import hu.nemethi.mybudget.mapping.UserMapper;
import hu.nemethi.mybudget.repository.UserRepository;
import hu.nemethi.mybudget.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService<UserDto> {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;
    private UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto login(UserDto userDto) {
        throw new UnsupportedOperationException("Not yet implemented!");
    }

    @Override
    public void logout(Integer userId) {
        throw new UnsupportedOperationException("Not yet implemented!");
    }

    @Override
    public void delete(UUID userId) {
        userRepository.deleteById(userId);
    }

    @Override
    @Transactional
    public UserDto create(UserDto userDto) {
        User user = userMapper.mapDtoToEntity(userDto);
        return userMapper.mapEntityToDto(userRepository.save(user));
    }

    @Override
    public UserDto modify(UserDto userDto) {
        return this.create(userDto);
    }

    @Override
    public UserDto findByUserId(UserDto userDto) {
        Optional<User> user = userRepository.findById(userDto.getId());
        return userMapper.mapEntityToDto(user.get());

    }

}
