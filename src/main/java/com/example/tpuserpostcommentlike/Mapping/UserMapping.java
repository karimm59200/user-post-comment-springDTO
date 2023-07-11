package com.example.tpuserpostcommentlike.Mapping;

import com.example.tpuserpostcommentlike.dto.UserDto;
import com.example.tpuserpostcommentlike.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapping implements EntityDto<UserDto, User>{

        @Override
        public UserDto convertToDto(User entity) {
            UserDto userDto = new UserDto();
            userDto.setId(entity.getId());
            userDto.setUsername(entity.getUsername());
            return userDto;
        }

        @Override
        public User convertToEntity(UserDto dto) {
            User user = new User();
            user.setId(dto.getId());
            user.setUsername(dto.getUsername());
            return user;
        }
}
