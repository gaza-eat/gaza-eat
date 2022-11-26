package code.dto;

import code.domain.user.UserEntity;
import lombok.Data;

@Data
public class UserDto 
{
    String id;
    String pw;

    public UserEntity toEntity()
    {
        UserEntity e = new UserEntity();
        e.setId(id);
        e.setPassword(pw);

        return e;
    }

}
