package com.motors.mvc.service;

import com.motors.programm.bread.BreadCrumb;
import com.motors.programm.bread.BreadCrumbTree;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("IBreadCrumbTreeService")
public class BreadCrumbTreeServiceImpl implements IBreadCrumbTreeService {

    @Override
    public void addNode(String nodeName, int level, HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        BreadCrumb node = new BreadCrumb(nodeName, referrer, level);
        BreadCrumbTree tree = (BreadCrumbTree) request.getSession().getAttribute("breadcrumb");
        if (tree == null) {
            tree = new BreadCrumbTree();
        }
        request.getSession().setAttribute("breadcrumb", tree);
        tree.addNode(node);
    }
}
