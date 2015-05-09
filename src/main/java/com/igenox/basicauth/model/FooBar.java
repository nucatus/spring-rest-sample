package com.igenox.basicauth.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alexandru.ionita on 5/9/15.
 */
@XmlRootElement
public class FooBar
{

    private String name;
    private String id;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
