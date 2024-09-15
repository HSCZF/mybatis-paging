package org.example.domain.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CZF
 * @Create: 2024/6/6 - 10:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBaseResp<T> {

    /**
     * 当前页数
     */
    private Integer pageNo;
    /**
     * 每页查询数量
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Long totalRecords;

    /**
     * 数据列表
     */
    private List<T> list;

    /**
     * 创建一个空的分页响应对象
     *
     * @param <T> 泛型类型
     * @return 分页响应对象
     */
    public static <T> PageBaseResp<T> empty() {
        PageBaseResp<T> r = new PageBaseResp<>();
        r.setPageNo(1);
        r.setPageSize(0);
        r.setTotalRecords(0L);
        r.setList(new ArrayList<>());
        return r;
    }


}
