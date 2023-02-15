package cn.hyqup.dict.bin;

import lombok.Data;

import java.util.Date;

@Data
public class CodeDict {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long pkId;
    /**
     * code
     */
    private String dictCode;
    /**
     * 名称
     */
    private String dictName;
    /**
     * value
     */
    private String dictValue;
    /**
     * 字典分类
     */
    private String dictCategory;
    /**
     * 创建人
     */
    private Long fkUserCreate;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改人
     */
    private Long fkUserModified;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 是否启用
     */
    private Integer enabled;
    /**
     * 层级
     */
    private Long level;
    /**
     * 排序
     */
    private Long sort;
}
