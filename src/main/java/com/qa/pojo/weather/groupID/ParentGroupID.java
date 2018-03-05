package com.qa.pojo.weather.groupID;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentGroupID {

@SerializedName("cnt")
@Expose
private Integer cnt;
@SerializedName("list")
@Expose
private List<com.qa.pojo.weather.groupID.List> list = null;

public Integer getCnt() {
return cnt;
}

public void setCnt(Integer cnt) {
this.cnt = cnt;
}

public List<com.qa.pojo.weather.groupID.List> getList() {
return list;
}

public void setList(List <com.qa.pojo.weather.groupID.List> list) {
this.list = list;
}

}
