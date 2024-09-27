package com.java.travel_cross_platform_be.Converter;


import com.java.travel_cross_platform_be.DTOs.Request.RegisterReq;
import com.java.travel_cross_platform_be.DTOs.DTO.UserDTO;
import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDTO convertToDTO(TravelUser userEntity) {
        UserDTO userDTO = new UserDTO();
        // Sao chép thuộc tính từ entity sang DTO
        BeanUtils.copyProperties(userEntity, userDTO);
        return userDTO;
    }

    public TravelUser convertToEntity(UserDTO userDTO) {
        TravelUser userEntity = new TravelUser();
        // Sao chép thuộc tính từ DTO sang entity
        BeanUtils.copyProperties(userDTO, userEntity);
        return userEntity;
    }
    public TravelUser convertToEntity(RegisterReq registerReq) {
        TravelUser userEntity = new TravelUser();
        // Sao chép thuộc tính từ DTO sang entity
        BeanUtils.copyProperties(registerReq, userEntity);
        return userEntity;
    }
}
