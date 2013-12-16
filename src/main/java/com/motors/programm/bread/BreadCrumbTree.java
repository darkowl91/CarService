package com.motors.programm.bread;

import java.util.ArrayList;
import java.util.List;

public final class BreadCrumbTree {
    private List<BreadCrumb> breadCrumbs;

    public BreadCrumbTree() {
        breadCrumbs = new ArrayList<BreadCrumb>();
    }

    private BreadCrumb findNode(BreadCrumb node) {
        for (BreadCrumb n : breadCrumbs) {
            if (n.getLevel() == node.getLevel()) {
                return n;
            }
        }
        return null;
    }

    public void addNode(BreadCrumb node) {
        BreadCrumb c = findNode(node);
        if (c != null) {
            int position = breadCrumbs.indexOf(c);
            for (int i = breadCrumbs.size() - 1; i >= position; i--) {
                breadCrumbs.remove(i);
            }
        } else {
            if (breadCrumbs.size() > 0) {
                breadCrumbs.get(breadCrumbs.size() - 1).setValue(node.getValue());
            }
        }
        breadCrumbs.add(node);

        List<BreadCrumb> nodeToRemove = new ArrayList<BreadCrumb>();
        for (int i = 0; i < breadCrumbs.size() - 1; i++) {
            if (breadCrumbs.get(i).getLevel() >= breadCrumbs.get(breadCrumbs.size() - 1).getLevel()) {
                nodeToRemove.add(breadCrumbs.get(i));
            }
        }

        for (BreadCrumb remove : nodeToRemove) {
            breadCrumbs.remove(remove);
        }
    }

    public List<BreadCrumb> getBreadCrumbs() {
        return breadCrumbs;
    }
}
