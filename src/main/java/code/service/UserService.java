package code.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.domain.user.UserEntity;
import code.domain.user.UserRepository;
import code.dto.UserDto;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class UserService 
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    final HttpServletRequest request;

    public String signUp(UserDto dto)
    {

        try{
            userRepository.save(dto.toEntity());
            return "redirect:/";
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return "redirect:/user/signup";
        }
        
    }

    public String login(UserDto dto)
    {
        try{
            UserEntity entity = userRepository.findById(dto.getId());
            // ID와 패스워드 검사
            if(entity == null) return "redirect:/user/login";
            if(!entity.getPassword().equals(dto.getPw())) return "redirect:/user/login";
    
            HttpSession session = request.getSession();
            session.setAttribute("userNo", entity.getUserNo());
            session.setAttribute("id", entity.getId());
            session.setAttribute("password", entity.getPassword());

            return "redirect:/";
        } catch(Exception e){
            System.out.println(e.getMessage());
            return "redirect:/user/login";
        }


    }

    public boolean isLogin()
    {
        if(request.getSession().getAttribute("userNo").equals(null))
            return false;
        else
            return true;

    }

    // 현재 세션에 저장되어 있는 유저 번호를 반환
    public Long getUserNo()
    {
        return (Long)request.getSession().getAttribute("userNo".toString());
    }

    // 인수로 받은 번호와 현재 유저 번호가 같다면 true
    public boolean isSameUser(Long userNo)
    {
        Long sNo = getUserNo();
        if(sNo == null) return false;
        return (sNo == userNo);
    }
    
}
