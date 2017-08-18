package com.zyz.jdk8.bo;

import java.util.List;

/**
 * User: 张月忠
 * Date: 2017/8/18
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */

public class Artist {
    private String name;//艺术家名称
    private List<String> members;//成员
    private String orgin;//来源

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getOrgin() {
        return orgin;
    }

    public void setOrgin(String orgin) {
        this.orgin = orgin;
    }
}
