package com.delgadomiguel.main.services;

import com.delgadomiguel.main.domain.User;
import com.delgadomiguel.main.mapper.UserMapper;
import com.delgadomiguel.main.repositories.UserRepository;
import com.delgadomiguel.main.requests.UserPostRequestBody;
import com.delgadomiguel.main.requests.UserPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User findByIdOrThrowBadRequestException(Long id) throws BadRequestException {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }

    @Transactional
    public User save (UserPostRequestBody userPostRequestBody){
        return userRepository.save(UserMapper.INSTANCE.toUser(userPostRequestBody));
    }

    public void deleteById(long id){
        userRepository.deleteById(id);
    }

    public void replace(UserPutRequestBody userPutRequestBody) throws BadRequestException {
        User savedUser = findByIdOrThrowBadRequestException(userPutRequestBody.getId());
        User user = UserMapper.INSTANCE.toUser(userPutRequestBody);
        user.setId(savedUser.getId());
        user.setEmail(savedUser.getEmail());
        userRepository.save(user);
    }
}
