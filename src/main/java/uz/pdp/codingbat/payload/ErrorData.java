package uz.pdp.codingbat.payload;

import com.sun.mail.imap.protocol.INTERNALDATE;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Access;

@Getter
@AllArgsConstructor
public class ErrorData {
    private String msg;

    private Integer code;

    private String fieldName;

    public ErrorData(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }
}
