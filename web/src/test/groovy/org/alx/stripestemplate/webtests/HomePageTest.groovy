package org.alx.stripestemplate.webtests

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
class HomePageTest  extends WebTestBase{

  void testHome(){
    webtest("HomePage test"){
      goToPage '/Home'
      verifyTitle "Home"
    }
  }
}
