package cn.eli.action;

import cn.eli.entity.EliUserEntity;
import cn.eli.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

    @Resource
    private UserService userService;

    private EliUserEntity user;

    public EliUserEntity getUser() {
        return user;
    }

    public void setUser(EliUserEntity user) {
        this.user = user;
    }

    public String login() {
        if (userService.login(user)) {
            Map session = ActionContext.getContext().getSession();
            session.put("user", user);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
