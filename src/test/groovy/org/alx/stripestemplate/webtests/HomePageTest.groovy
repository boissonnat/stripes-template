package org.alx.stripestemplate.webtests

/**
 * Created by IntelliJ IDEA.
 * User: boissonnat
 * Date: 27/09/11
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 */
class HomePageTest  extends WebTestBase{

  void testHome(){
    webtest("HomePage test"){
      goToPage '/Home.htm'
      verifyTitle "Home"
    }
  }
}
