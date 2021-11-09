package springboot.register;

import java.sql.Timestamp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.util.GlobalService;

@RestController
public class RegisterController {

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/reg")
    public String insert(@RequestBody @Valid MemberBean member) {
        String account = member.getAccount();
        if(memberRepository.findByAccount(account) != null){
            return "已有重複帳號，請更改";
        } else {
            String enPswd = GlobalService.encryptString(member.getPassword());
            Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
            member.setPassword(enPswd);
            member.setJoin_Date(ts);
            memberRepository.save(member);
            return "註冊成功，請重新登入";
        }
    }
}
