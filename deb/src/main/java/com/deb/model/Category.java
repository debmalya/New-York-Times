/**
 * 
 */
package com.deb.model;

import java.io.Serializable;


/**
 * @author Debmalya Jash
 * This represents a Category.
 */
public class Category implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = -8150614707296252332L;
  private String display_name;
  private String section;
  
 
  
  /**
   * @return the section
   */
  public String getSection ()
  {
    return section;
  }
  
  /**
   * @param section the section to set
   */
  public void setSection (String section)
  {
    this.section = section;
  }

  public Category (String displayName, String section)
  {
    super ();
    this.display_name = displayName;
    this.section = section;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString ()
  {
    return "Category [displayName=" + display_name + ", section=" + section + "]";
  }

  
  /**
   * @return the display_name
   */
  public String getDisplay_name ()
  {
    return display_name;
  }

  
  /**
   * @param display_name the display_name to set
   */
  public void setDisplay_name (String display_name)
  {
    this.display_name = display_name;
  }
  
  
}
