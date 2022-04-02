package liuyang.testweb.commons.util;

/**
 * 构建分页查询的返回结果（将Page包装成R类型的返回值）
 * @author liuyang
 * @scine 2021/4/22
 */
public class RPage {
    /**
     * 机械完成在R中拼接如下部分的动作
     * "data" : {
     *     "count": page.getTotal()
     *     , "records": page.Records()
     * }
     * 使用示例：
     *      RPageUtil.build(page);
     * @param page
     * @return
     */
/*    public static R build(IPage page) {
        Map<String, Object> data = new HashMap<>();
        data.put("count", page.getTotal());// 总记录数
        data.put("records", page.getRecords());// 数据
        return R.ok().put("data", data);
    }*/
}
