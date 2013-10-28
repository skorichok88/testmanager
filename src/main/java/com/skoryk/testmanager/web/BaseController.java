package com.skoryk.testmanager.web;

public class BaseController
{
    private volatile String viewPrefix = null;

    public String getViewPrefix()
    {
        if (null == viewPrefix)
            synchronized (this.getClass())
            {
                if (null == viewPrefix)
                    viewPrefix = this.getClass().getCanonicalName()
                            .replaceAll("\\.", "/")
                            .replaceFirst("^" + CommonUrl.VIEW_PREFIX.substring(1) + "/", "")
                            .replaceFirst("/" + this.getClass().getSimpleName() + "$", "");
            }

        return viewPrefix;
    }

    public String getView(String viewName)
    {
        return getViewPrefix() + viewName;
    }
}
