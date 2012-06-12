package com.mohansrihari.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.mohansrihari.common.Context;

public class ContextProperty extends SimpleTagSupport
{
    private String name = null;
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public void doTag() throws JspException, IOException
    {
        try
        {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            out.print(Context.getString(name));            
        }
        catch (IOException ioe)
        {
            throw new JspException("Error: IOException while writing to client"
                    + ioe.getMessage());
        }
    }
}
