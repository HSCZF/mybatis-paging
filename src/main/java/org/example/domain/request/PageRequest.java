package org.example.domain.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Description:
 *
 * @author CZF
 * @date 2024/9/14 - 20:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {

    /**
     * 页面大小
     */
    @Min(0)
    @Max(50)
    private Integer pageSize = 10;

    /**
     * 页面索引（从1开始）
     */
    private Integer pageNo = 1;

    public Page plusPage() {
        return new Page(pageNo, pageSize);
    }


}
