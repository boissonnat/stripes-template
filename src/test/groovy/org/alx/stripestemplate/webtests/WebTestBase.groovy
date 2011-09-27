package org.alx.stripestemplate.webtests

/**
 * Created by IntelliJ IDEA.
 * User: boissonnat
 * Date: 27/09/11
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
abstract class WebTestBase extends com.canoo.webtest.WebtestCase {

  def homeUrl = 'http://localhost:8080/stripes-template'

  void goToPage(String url) {
    ant.invoke(homeUrl + url)
  }
}