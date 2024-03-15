package cn.hyqup.netty.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString(callSuper = true)
public class LoginResponseMessage extends AbstractResponseMessage {

    @Override
    public int getMessageType() {
        return LoginResponseMessage;
    }

    public LoginResponseMessage(boolean success, String reason) {
        super(success, reason);
    }
}
