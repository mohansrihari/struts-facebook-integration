package com.prokarma.tags.facebook;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.prokarma.util.Util;

public class FeedDialog extends SimpleTagSupport
{
    private String dialogType = null;
    
    /**
     * Requires set of resources named as follows to define params for FB 'feed' dialog. 
     * 
     * feedDialog.${dialogType}.link
     * feedDialog.${dialogType}.picture
     * feedDialog.${dialogType}.name
     * feedDialog.${dialogType}.caption
     * feedDialog.${dialogType}.description
     * 
     * @param dialogType
     */
    public void setDialogType(String dialogType)
    {
        this.dialogType = dialogType;
    }
    
    private HttpServletRequest request;
    
    @Override
    public void doTag() throws JspException, IOException
    {
        try
        {
            PageContext pageContext = (PageContext) getJspContext();
            request = (HttpServletRequest)pageContext.getRequest();
            
            JspWriter out = pageContext.getOut();
            
            StringBuilder sbOut = new StringBuilder();
            final String NL = System.getProperty("line.separator");
            sbOut.append(  "<script type=\"text/javascript\">"                                                + NL);
            sbOut.append(  "   function feedDialog() {"                                                       + NL);
            sbOut.append(  "       var obj = {"                                                               + NL);
            sbOut.append(  "         method      : 'feed',"                                                   + NL);
            sbOut.append(f("         link        : '%s',"           , getProp("link"))                        + NL);
            sbOut.append(f("         picture     : '%s',"           , getProp("picture"))                     + NL);
            sbOut.append(f("         name        : '%s',"           , getProp("name"))                        + NL);
            sbOut.append(f("         caption     : '%s',"           , getProp("caption"))                     + NL);
            sbOut.append(f("         description : '%s'"            , getProp("description"))                 + NL);
            sbOut.append(  "       };"                                                                        + NL);
            sbOut.append(  "       "                                                                          + NL);
            sbOut.append(  "       function callback(response) {"                                             + NL);
            sbOut.append(  "       }"                                                                         + NL);
            sbOut.append(  "       "                                                                          + NL);
            sbOut.append(  "       $(document).ready(function(){ FB.ui(obj, callback); });"                   + NL);
            sbOut.append(  "   }"                                                                             + NL);
            sbOut.append(  "   feedDialog();"                                                                 + NL);
            sbOut.append(  "</script>"                                                                        + NL);
            
            out.print(sbOut.toString());            
        }
        catch (IOException ioe)
        {
            throw new JspException("Error: IOException while writing to client"
                    + ioe.getMessage());
        }
    }
    
    private String getProp(String propName) {
        String key = "feedDialog." + dialogType + "." + propName;
        return Util.getMessageFromResource(key, request);
    }
    
    private String f(String str, Object... args)
    {
        return String.format(str, args);
    }
}
