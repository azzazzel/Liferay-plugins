package com.commsen.liferay.portlet.customglobalmarkup.model;

import com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class MarkupClp extends BaseModelImpl<Markup> implements Markup {
    private long _id;
    private long _companyId;
    private long _groupId;
    private String _markup;
    private boolean _active;
    private short _location;

    public MarkupClp() {
    }

    public Class<?> getModelClass() {
        return Markup.class;
    }

    public String getModelClassName() {
        return Markup.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public String getMarkup() {
        return _markup;
    }

    public void setMarkup(String markup) {
        _markup = markup;
    }

    public boolean getActive() {
        return _active;
    }

    public boolean isActive() {
        return _active;
    }

    public void setActive(boolean active) {
        _active = active;
    }

    public short getLocation() {
        return _location;
    }

    public void setLocation(short location) {
        _location = location;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            MarkupLocalServiceUtil.addMarkup(this);
        } else {
            MarkupLocalServiceUtil.updateMarkup(this);
        }
    }

    @Override
    public Markup toEscapedModel() {
        return (Markup) Proxy.newProxyInstance(Markup.class.getClassLoader(),
            new Class[] { Markup.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        MarkupClp clone = new MarkupClp();

        clone.setId(getId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setMarkup(getMarkup());
        clone.setActive(getActive());
        clone.setLocation(getLocation());

        return clone;
    }

    public int compareTo(Markup markup) {
        long primaryKey = markup.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        MarkupClp markup = null;

        try {
            markup = (MarkupClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = markup.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", markup=");
        sb.append(getMarkup());
        sb.append(", active=");
        sb.append(getActive());
        sb.append(", location=");
        sb.append(getLocation());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.commsen.liferay.portlet.customglobalmarkup.model.Markup");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>markup</column-name><column-value><![CDATA[");
        sb.append(getMarkup());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>location</column-name><column-value><![CDATA[");
        sb.append(getLocation());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
