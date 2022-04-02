package liuyang.testweb.commons.util;

/**
 * 操作返回值工具类
 * @author liuyang
 * @scine 2021/4/22
 */
public class RFlag {
    /*
    机械完成如下动作
    if (success) {
            return R.ok();
        } else {
            return R.error("操作失败");
        }
     */
    public static R build(boolean success) {
        if (success) {
            return R.ok();
        } else {
            return R.error("操作失败");
        }
    }

}
