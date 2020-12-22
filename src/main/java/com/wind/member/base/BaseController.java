package com.wind.member.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BaseController
{

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    public void setTitle(ModelMap map, String title, String parenttitle, boolean isMsg,
                         String msgHtml, boolean isControl, boolean isribbon){
    	//标题
    	map.put("title",title);
    	map.put("parenttitle",parenttitle);
		//是否打开欢迎语
    	map.put("isMsg",isMsg);
		//欢迎语
    	map.put("msgHTML",msgHtml);
		//小控件
    	map.put("isControl",isControl);
		map.put("isribbon",isribbon);
    }

   
}
