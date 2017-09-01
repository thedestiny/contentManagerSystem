/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * <p>
 * Copyright 2017 © yangxiaobing, 873559947@qq.com
 * <p>
 * This file is part of contentManagerSystem.
 * contentManagerSystem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * contentManagerSystem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with contentManagerSystem.  If not, see <http://www.gnu.org/licenses/>.
 * <p>
 * 这个文件是contentManagerSystem的一部分。
 * 您可以单独使用或分发这个文件，但请不要移除这个头部声明信息.
 * contentManagerSystem是一个自由软件，您可以自由分发、修改其中的源代码或者重新发布它，
 * 新的任何修改后的重新发布版必须同样在遵守GPL3或更后续的版本协议下发布.
 * 关于GPL协议的细则请参考COPYING文件，
 * 您可以在contentManagerSystem的相关目录中获得GPL协议的副本，
 * 如果没有找到，请连接到 http://www.gnu.org/licenses/ 查看。
 * <p>
 * - Author: yangxiaobing
 * - Contact: 873559947@qq.com
 * - License: GNU Lesser General Public License (GPL)
 * - source code availability: http://git.oschina.net/yangxiaobing_175/contentManagerSystem
 */
package com.yxb.cms.controller.system;

import com.yxb.cms.controller.BasicController;
import com.yxb.cms.domain.vo.AnnouncementInfo;
import com.yxb.cms.domain.vo.User;
import com.yxb.cms.service.AnnouncementInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 公告管理Controller
 *
 * @author yangxiaobing
 * @date 2017/9/1
 */
@Controller
@RequestMapping("announcement")
public class AnnouncementInfoController extends BasicController {


    @Autowired
    private AnnouncementInfoService announcementInfoService;

    /**
     *跳转到公告列表页面
     * @return
     */
    @RequestMapping("/announcement_list.do")
    public String toAnnouncementListPage() {
        return "system/announcement_list";
    }

    /**
     * 公告列表List
     * @param announcement 公告实体
     * @return
     */
    @RequestMapping("/ajax_announcement_list.do")
    @ResponseBody
    public String ajaxUserList(AnnouncementInfo announcement) {
        return announcementInfoService.selectAnnInfoResultPageList(announcement);
    }


    /**
     * 公告详情页面
     * @param model
     * @param announcementId 公告Id
     * @return
     */
    @RequestMapping("/announcement_detail.do")
    public String toAnnouncementDetailPage(Model model, Integer announcementId) {
        AnnouncementInfo announcementInfo = announcementInfoService.selectAnnouncementInfoById(announcementId);
        model.addAttribute("announcementInfo",announcementInfo);
        return "system/announcement_detail";
    }


}