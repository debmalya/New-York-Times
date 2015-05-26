package com.deb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author debmalya jash
 *
 */
public class Categories implements Serializable
{
  public Categories ()
  {
    super ();
    this.categoryList = new ArrayList<Category>();
  }


  /**
   * 
   */
  private static final long serialVersionUID = 834406723420380339L;
  
  /**
   * List of categories
   */
  private List<Category> categoryList;

  
  /**
   * @return the categoryList
   */
  public List<Category> getCategoryList ()
  {
    return categoryList;
  }

  
  /**
   * @param categoryList the categoryList to set
   */
  public void setCategoryList (List<Category> categoryList)
  {
    this.categoryList = categoryList;
  }


  public Categories (List<Category> categoryList)
  {
    super ();
    this.categoryList = categoryList;
  }
  
  
}
