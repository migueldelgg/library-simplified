package com.delgadomiguel.main.mapper;

import com.delgadomiguel.main.domain.User;
import com.delgadomiguel.main.requests.UserPostRequestBody;
import com.delgadomiguel.main.requests.UserPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract User toUser (UserPostRequestBody userPostRequestBody);
    public abstract User toUser (UserPutRequestBody userPutRequestBody);
}
