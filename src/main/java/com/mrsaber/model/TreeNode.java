package com.mrsaber.model;

import java.util.List;

public class TreeNode {
    /**
     * id: node id, which is important to load remote data
     text: node text to show
     state: node state, 'open' or 'closed', default is 'open'. When set to 'closed', the node have children nodes and will load them from remote site
     checked: Indicate whether the node is checked selected.
     attributes: custom attributes can be added to a node
     children: an array nodes defines some children nodes
     */
    private String id;
    private String text;
    private String state;
    private String checked;
    public List<TreeNode> children;
    private TreeNodeAttr attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public TreeNodeAttr getAttributes() {
        return attributes;
    }

    public void setAttributes(TreeNodeAttr attributes) {
        this.attributes = attributes;
    }
}
