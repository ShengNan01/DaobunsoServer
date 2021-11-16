package springboot.register;

import java.sql.Timestamp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import springboot.login.LoginRepo;
import springboot.util.GlobalService;
import springboot.util.MailUtils;

@Log4j2
@RestController
public class RegisterController {

	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	
	@Autowired
	public MailUtils mailutils;
	@Autowired
	private MemberRepository memberRepository;

	@PostMapping("/reg")
	public String insert(@RequestBody @Valid MemberBean member) {
		String account = member.getAccount();
		if (memberRepository.findByAccount(account) != null) {
			return "已有重複帳號，請更改";
		} else {
			String enPswd = GlobalService.encryptString(member.getPassword());
			Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
			member.setPassword(enPswd);
			member.setJoin_Date(ts);
			memberRepository.save(member);
			log.info("寄送驗證信");
			mailutils.sendEmail(member, member.getEmail());
			return "註冊成功，請重新登入";
		}
	}
	
    @Autowired
	LoginRepo loginRepo;
    @PostMapping("/app/reg")
    public String appInsert(@RequestBody @Valid MemberBean member) {
        String account = member.getAccount();
        if(memberRepository.findByAccount(account) != null){
            return "已有重複帳號，請更改";
        } else {
            String enPswd = GlobalService.encryptString(member.getPassword());
            Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
            member.setPassword(enPswd);
            member.setJoin_Date(ts);
            memberRepository.save(member);
            String memberId = loginRepo.findMemberIdByAccount(account).toString();
            return "註冊成功，請重新登入"+"-"+memberId;
        }
    }
}
