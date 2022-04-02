package liuyang.testweb.commons.util;

/**
 * @author liuyang(wx)
 * @since 2021/4/27
 */
public class RData {
    /*
    机械完成如下动作
    R.ok().put("data", Object)
     */
    public static R build(Object data) {
        return R.ok().put("data", data);
    }
}
