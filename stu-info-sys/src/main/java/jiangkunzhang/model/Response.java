package jiangkunzhang.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/26 12:16
 */

@Getter
@Setter
@ToString
public class Response {
    private boolean success;//业务是否处理成功
    private Integer total;//分页操作时需要的总数量
    private String code;//错误码
    private String message;//错误消息
    private Object data;//业务字段
    private String stackTrance;//出现异常时，堆栈信息
}
