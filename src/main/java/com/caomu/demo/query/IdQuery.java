package com.caomu.demo.query;

import javax.validation.constraints.NotNull;

/**
 * 入参id
 *
 * @author 刘斌
 */
public class IdQuery {

    /**
     * id
     */
    @NotNull(message = "【ID不能为空】")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
