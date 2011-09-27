package org.alx.stripestemplate.webtests

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
abstract class WebTestBase extends com.canoo.webtest.WebtestCase {

  def homeUrl = 'http://localhost:8080/stripes-template'

  void goToPage(String url) {
    ant.invoke(homeUrl + url)
  }
}